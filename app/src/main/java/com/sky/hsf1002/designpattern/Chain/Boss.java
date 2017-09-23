package com.sky.hsf1002.designpattern.Chain;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class Boss extends Leader{
    Boss()
    {
        System.out.println("Boss limit: " + limit());
    }

    @Override
    protected int limit() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected void handle(int money) {
        System.out.println("Boss handle. " + money);
    }
}
