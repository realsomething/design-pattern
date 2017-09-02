package com.sky.hsf1002.designpattern.Singleton;

/**
 * Created by hsf1002 on 2017/9/2.
 */

public class SingletonHolder {

    private SingletonHolder()
    {
    }

    public static SingletonHolder getInstance()
    {
        return Holder.sInstance;
    }

    private static class Holder
    {
        private static final SingletonHolder sInstance = new SingletonHolder();
    }
}
