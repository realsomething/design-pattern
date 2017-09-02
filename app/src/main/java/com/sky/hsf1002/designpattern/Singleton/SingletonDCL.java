package com.sky.hsf1002.designpattern.Singleton;

/**
 * Created by hsf1002 on 2017/9/2.
 */

public class SingletonDCL {

    private static SingletonDCL sInstance = null;

    private SingletonDCL()
    {
    }

    public static SingletonDCL getInstance()
    {
        if (sInstance == null)
        {
            synchronized (SingletonDCL.class)
            {
                if (sInstance == null)
                {
                    sInstance = new SingletonDCL();
                }
            }
        }

        return sInstance;
    }
}
