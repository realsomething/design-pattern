package com.sky.hsf1002.designpattern.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class DynamicProxy implements InvocationHandler {
    private Object obj;

    DynamicProxy(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(obj, args);

        return result;
    }
}
