package com.sky.hsf1002.designpattern.Adapter;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class ForeignCenter {

    private String name;

    ForeignCenter(String name)
    {
        this.name = name;
    }

    public void attack()
    {
        System.out.println("foreign player " + name + " attack.");
    }

    public void defense()
    {
        System.out.println("foreign player " + name + " defense.");
    }

    public String getName() {
        return name;
    }
}
