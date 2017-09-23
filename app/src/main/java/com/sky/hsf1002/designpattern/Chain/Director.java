package com.sky.hsf1002.designpattern.Chain;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class Director extends Leader{
    Director()
    {
        System.out.println("Director limit: " + limit());
    }

    @Override
    protected int limit() {
        return 10000;
    }

    @Override
    protected void handle(int money) {
        System.out.println("Director handle. " + money);
    }
}
