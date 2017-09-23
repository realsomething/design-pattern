package com.sky.hsf1002.designpattern.Chain;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class GroupLeader extends Leader{

    GroupLeader()
    {
        System.out.println("GroupLeader limit: " + limit());
    }

    @Override
    protected int limit() {
        return 1000;
    }

    @Override
    protected void handle(int money) {
        System.out.println("GroupLeader handle. " + money);
    }
}
