package com.sky.hsf1002.designpattern.Adapter;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class CenterPlayer extends Player {

    CenterPlayer(String name)
    {
        this.name = name;
    }

    @Override
    void attack() {
        System.out.println("center player " + name + " attack.");
    }

    @Override
    void defense() {
        System.out.println("center player " + name + " defense.");
    }
}
