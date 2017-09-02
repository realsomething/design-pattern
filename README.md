# design-pattern
common design patterns in Android.


## Singleton
构造函数不对外开放，只有一个静态方法返回单例类对象，需确保在多线程下保持单例类对象只有一个，并在反序列化时不会重新构建对象  
* 懒汉模式：使用时才初始化，一定程度上节约资源，但是第一次加载需要实例化，且每次调用需要同步，开销较大，不建议使用
* Double Check Lock模式：第一层判断为了不必要的同步，第二层为了在null的情况下创建实例；优点是解决了资源消耗，多余同步和线程安全问题，但是在某些情况下存在DCL失效情况
* 静态内部类模式：线程安全，也能保证单例对象的唯一性，同时延迟了单例的实例化，是推荐的实现方式  
还可以通过枚举和容器实现  

`Android中的单例模式`  
`WindowManagerService，ActivityManagerService，LayoutInflater Service，InputMethodManager Service`等都是以容器方式创建  
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

