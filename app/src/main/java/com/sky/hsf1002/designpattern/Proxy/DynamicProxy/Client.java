package com.sky.hsf1002.designpattern.Proxy.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class Client {
    public static void main(String [] args)
    {
        ILawsuit customer = new Customer("xiaoming");
        DynamicProxy dynamicProxy = new DynamicProxy(customer);

        ClassLoader loader = customer.getClass().getClassLoader();
        ILawsuit lawyer = (ILawsuit)Proxy.newProxyInstance(loader, new Class[]{ILawsuit.class}, dynamicProxy);

        lawyer.summit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }
}
