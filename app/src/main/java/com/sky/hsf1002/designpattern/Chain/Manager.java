package com.sky.hsf1002.designpattern.Chain;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class Manager extends Leader{

    Manager()
    {
        System.out.println("Manager limit: " + limit());
    }

    @Override
    protected int limit() {
        return 50000;
    }

    @Override
    protected void handle(int money) {
        System.out.println("Manager handle. " + money);
    }
}
