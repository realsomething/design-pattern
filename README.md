# design-pattern
common design patterns in Android.


## 单例模式-Singleton
构造函数不对外开放，只有一个静态方法返回单例类对象，需确保在多线程下保持单例类对象只有一个，并在反序列化时不会重新构建对象  
* 懒汉模式：使用时才初始化，一定程度上节约资源，但是第一次加载需要实例化，且每次调用需要同步，开销较大，不建议使用  
* Double Check Lock模式：第一层判断为了不必要的同步，第二层为了在null的情况下创建实例；优点是解决了资源消耗，多余同步和线程安全问题，但是在某些情况下存在DCL失效情况  
* 静态内部类模式：线程安全，也能保证单例对象的唯一性，同时延迟了单例的实例化，是推荐的实现方式  
还可以通过枚举和容器实现  

Android：`WMS，AMS，LayoutInflater Service，InputMethodManager Service`   等都是以容器方式创建  
```
private static final HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP =
            new HashMap<String, ServiceFetcher>();
// register map
    private static void registerService(String serviceName, ServiceFetcher fetcher) {
        if (!(fetcher instanceof StaticServiceFetcher)) {
            fetcher.mContextCacheIndex = sNextPerContextServiceCacheIndex++;
        }
        SYSTEM_SERVICE_MAP.put(serviceName, fetcher);
    }
// initialization just once
        registerService(LAYOUT_INFLATER_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return PolicyManager.makeNewLayoutInflater(ctx.getOuterContext());
                }});
// get the instance                
    public Object getSystemService(String name) {
        ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
        return fetcher == null ? null : fetcher.getService(this);
    }
```

## 观察者模式-Observer
观察者模式定义了一个一对多的依赖关系，让一个或多个观察者对象监听一个主题对象。当被观察者状态发生改变时，需要通知相应的观察者，使这些观察者对象能够自动更新  
* 事件委托：观察者和通知者互相不知道，由客户端来决定通知谁  
* 事件总线：在一个Activity发送广播，另一个Activiy接收，比较麻烦，如果传递数据是类对象，还要序列化；在一个Activity，定义一个子线程处理任务，完成后必须用Handler或AsyncTask来更新UI，也比较麻烦；事件总线可以进一步简化Activity，Fragment，Service等组件间的交互，很大程度上降低了它们的耦合  

Android：`Broadcard Receiver`的注册机制；ListView里面Adapter的方法`notifyDataSetChanged`  


## 享元模式-FlyWeight
对象池的一种实现，适用于存在大量重复对象的场景，可显著的减少对象创建数量减少内存使用  
* 可共享的、不变的状态为内部状态，经典实现会将内部状态作为键，对象作为值进行MAP存储，不可共享的、易变的状态为外部状态 
* 需要分离内部、外部状态，使得系统变得复杂，而且外部状态不会随着内部状态改变而改变，会导致系统逻辑混乱  

Android：`Message m = obtain();`对象池，并非享元模式的经典实现，简单的单链表    
如果对象池为空创建对象，否则从对象池获取消息并删除结点  
```
    public static Message obtain() {
        synchronized (sPoolSync) {
            if (sPool != null) {
                Message m = sPool;
                sPool = m.next;
                m.next = null;
                m.flags = 0; // clear in-use flag
                sPoolSize--;
                return m;
            }
        }
        return new Message();
    }
```
当消息被消费（处理）后，则重新加入对象池 
```
    void recycleUnchecked() {
        // Mark the message as in use while it remains in the recycled object pool.
        // Clear out all other details.
...
        synchronized (sPoolSync) {
            if (sPoolSize < MAX_POOL_SIZE) {
                next = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }
```
## 外观模式-Facade
封装API的常用手段，要求子系统的外部与其内部的通信必须通过一个统一的对象进行  
* 为复杂子系统提供一个简单接口，对外隐藏子系统的具体实现、隔离变化；如果构建一个层次结构的子系统，使用外观模式定义子系统每层的入口点，如果子系统之间是互相依赖的，可以让他们仅仅通过外观模式的接口进行通信  
* 外观类接口会增加，而且没有遵循开闭原则，当业务出现变更，可能需要修改外观类接口  

Android：`ContextImpl`，Activity（Service，Broadcast Receiver等）也是一个Context，其具体实现是ContextImpl，通过ContextWrapper、ContextThemeWrapper封装，如startActivity等接口最终实现是在ContextImpl中  

```
Context appContext = createBaseContextForActivity(r, activity);
....
// 将Application, ContextImpl, Activity联系起来
activity.attach(appContext, this, getInstrumentation(), r.token,
                        r.ident, app, r.intent, r.activityInfo, title, r.parent,
                        r.embeddedID, r.lastNonConfigurationInstances, config,
                        r.referrer, r.voiceInteractor);
....
// mBase为ContexImpl对象，Activity内部持有了ContextImpl的引用
    protected void attachBaseContext(Context base) {
        if (mBase != null) {
            throw new IllegalStateException("Base context already set");
        }
        mBase = base;
    }      
// 实际会调用ContextImpl的startActivity 
    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
    }
    
    
```

## 桥接模式-Bridge
将抽象部分和实现部分分离，让他们都能独立的进行变化，事实上，任何多维度变化或树型之间的耦合都可以通过桥接模式来解耦  
* 如果一个系统需要在构件的抽象变化角色和具体变化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承关系，可以通过桥接模式在抽象层建立一个关联关系  
* 易于理解，却难以设计，所以应用不多，一个重要的原因是不容易对于抽象和实现恰到好处的进行分离  

Android：`TextView, Button, CheckBox`等定义控件基本属性和行为的View和真正绘制他们的功能实现类如`DisplayList，HardwareLayer，Cavas`之间可以看做是桥接模式的应用，Adapter和AdapterView之间，Window和WindowManager之间也是  

## 装饰模式-Decorator
使用一种对客户端透明的方式来动态的扩展对象的功能，同时也是继承关系的一种替代方案之一  
* 使用场景：动态的给对象增加额外的职责，就增加功能来说，比生成子类更加灵活  
* 和代理模式容易混淆，代理模式是给一个对象提供一个代理对象，并由代理对象来控制对原有对象的引用，但不对对象本身的功能进行增强  

Android：`ContextWrapper`，ContextImpl是上帝对象Context的具体实现，ContextWrapper则扮演装饰者的角色，持有一个Context的对象  
```
public class ContextWrapper extends Context {
    Context mBase;
    public ContextWrapper(Context base) {
        mBase = base;
    }
....
    @Override
    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
    }
```

## 适配器模式-Adapter
把一个类的接口变换为客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类可以在一起工作，分为类适配器和对象适配器，类适配器需要多重继承支持，只讨论对象适配器模式    
* 如果系统的数据和行为都正确，只有接口不符时，或系统需要复用现有的类，而此类的接口不符合系统的需要，就可以使用适配器模式，也可以调用自己开发的功能，扩展系统功能
* 过多的使用会让系统非常凌乱，不容易整体把握，明明调用的是A，内部又被适配成了B；如果事先能预防接口不同的问题，不匹配的问题就不会发生，在有小的接口不统一发生问题时，及时重构，问题不至扩大，只有碰到无法改变原有设计和代码的情况下，才考虑适配

Android：`ListView中的Adapter`，输入（item view自定义视图）有无数种，通过增加一个Adapter来隔离变化，将ListView需要的关于item view接口抽象到Adapter对象中，并在ListView内部调用Adapter这些接口完成布局等操作，用户只要实现Adapter接口，就能保证有统一的输出  
## 组合模式-Composite
也称部分-整体模式，将一组相似的对象看作一个对象处理，并根据一个树形结构来组合对象，然后提供一个统一的方法去访问相应的对象，以此忽略掉对象与对象集合之间的差别，比较典型的例子是公司的组织结构树形图  
* 可以清楚的定义分层的复杂对象，让高层模块忽略层次差异，方便对整个层次结构进行控制，高层模块可以一致的使用一个组合结构或者其中单个对象，不必关心处理的是哪个，简化了高层模块的代码，增加新的枝干和叶节点都很方便，符合开闭原则，为树形结构的面向对象提供了一种灵活的解决方案，通过对枝干对象和叶对象的递归组合，可以形成复杂的树形结构，但对其控制却很简单
* 在新增构件时不好对枝干中的构件类型进行限制，不能依赖类型系统来施加这些约束，因为他们来自相同的抽象层，必须通过类型检查来实现，这个实现过程较为复杂

Android：`View和ViewGroup的嵌套组合`，ViewGroup或继承自ViewGroup的LinearLayout等控件作为容器可以包含TextView或其子类如Button、CheckBox等，然后反之不行，但是它们都继承自统一的抽象类View，且Android此处实现为安全的设计模式，若根据依赖倒置原则，按照透明的组合模式，叶节点（Button、TextView）和枝干节点（ViewGroup、LinearLayout）应有相同的结构（全部继承并实现根部抽象类View的方法），而叶节点不支持的方法则在类中进行判断识别   

## 代理模式-Proxy
也称委托模式，为其他对象提供一种代理以控制对这个对象的访问，当无法或不想直接访问某个对象或访问某个对象存在困难时可以通过一个代理对象来间接访问，为了保证客户端使用的透明性，委托对象和代理对象需要实现相同的接口，代理模式在现实中比比皆是，如让同事帮忙打饭，让律师帮忙打官司等  
* 静态代理：代理者的代码由程序猿或通过一些自动化工具生成固定的代码再对其编译，运行前代理类的class编译文件就已经确定，只能为给定接口下的实现类做代理，如果接口不同就需要重新定义不同的代理类，较为复杂，但是更符合面向对象原则  
* 动态代理：通过反射动态的生成代理者的对象，在code阶段不需要知道代理谁，在Java中可以通过动态代理接口InvocationHnadler实现，通过一个代理类来代理多个被代理类，其实质是对代理者与被代理者进行解耦    
* 远程代理、虚拟代理、保护代理、智能引用这四种可独自应用于静态代理和动态代理，两者各自独立对的变化  

Android：`ActivityManagerProxy代理类`，其代理的是ActivityManagerNative的子类ActivityManagerService，AMS是系统级服务并运行在独立的进程空间，而ActivityManagerProxy也运行于自己独立的进程空间，因此它们的通信通过Binder以跨进程方式进行，其实质是远程代理  


## 中介者模式-Mediator
也称调解者模式，包装了一系列对象相互作用的方式，使得这些对象不必相互明显作用，从而使他们可以松散耦合，将多对多的相互作用转化为一对多的相互作用，将系统从网状结构变成以调停者为中心的星型结构，降低了系统的复杂度，提高了可扩展性  
Android：`Binder机制`、锁屏功能的`KeyguardViewMediator`定义了很多管理器（音频、闹钟、搜索...），也定义了很多方法来处理这些管理器的状态  


## 访问者模式-Visitor
封装一些作用于某种数据结构中的各元素的操作，可以在不改变这个数据结构的前提下定义作用于这些元素的新操作，一种将数据结构和数据操作分离的设计模式，是23种常见设计模式种最复杂的一个，使用频率不高，可一旦需要，那就是真的需要了；适用于对象结构比较稳定，但是经常需要在此对象结构上定义新的操作，需要对一个对象结构的对象进行很多不同并且不相关的操作，且要避免这些操作污染这些类，也不希望增加新操作时修改类    
* 各角色职责分离，符合单一职责原则，具有优秀的扩展性，使得数据结构和作用于其上的操作解耦，操作集合可以独立变化
* 具体元素需要对访问者公布细节，违反了迪米特法则，具体元素变更时修改成本很大，违反了依赖倒置原则，为了区别对待，依赖了具体类

Android：`注解`  
