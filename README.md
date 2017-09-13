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




