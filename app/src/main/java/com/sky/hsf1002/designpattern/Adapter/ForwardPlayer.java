package com.sky.hsf1002.designpattern.Adapter;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class ForwardPlayer extends Player {

    ForwardPlayer(String name)
    {
        this.name = name;
    }

    @Override
    void attack() {
        System.out.println("forward player " + name + " attack.");
    }

    @Override
    void defense() {
        System.out.println("forward player " + name + " defense.");
    }
}
