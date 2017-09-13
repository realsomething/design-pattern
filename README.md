# design-pattern
common design patterns in Android.


## Singleton
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

## 观察者模式
观察者模式定义了一个一对多的依赖关系，让一个或多个观察者对象监听一个主题对象。当被观察者状态发生改变时，需要通知相应的观察者，使这些观察者对象能够自动更新  
* 事件委托：观察者和通知者互相不知道，由客户端来决定通知谁  
* 事件总线：在一个Activity发送广播，另一个Activiy接收，比较麻烦，如果传递数据是类对象，还要序列化；在一个Activity，定义一个子线程处理任务，完成后必须用Handler或AsyncTask来更新UI，也比较麻烦；事件总线可以进一步简化Activity，Fragment，Service等组件间的交互，很大程度上降低了它们的耦合  

Android：`Broadcard Receiver`的注册机制；ListView里面Adapter的方法`notifyDataSetChanged`  


## 享元模式
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
