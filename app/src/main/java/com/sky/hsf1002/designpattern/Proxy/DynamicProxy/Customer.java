package com.sky.hsf1002.designpattern.Proxy.DynamicProxy;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class Customer implements ILawsuit {
    private String name;

    Customer(String name)
    {
        this.name = name;
    }

    @Override
    public void summit() {
        System.out.println(name + " is summiting.");
    }

    @Override
    public void burden() {
        System.out.println(name + " is burdening.");
    }

    @Override
    public void defend() {
        System.out.println(name + " is defending.");
    }

    @Override
    public void finish() {
        System.out.println(name + " won the suit!");
    }
}
