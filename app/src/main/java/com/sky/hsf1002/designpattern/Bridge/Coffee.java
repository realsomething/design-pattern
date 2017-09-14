package com.sky.hsf1002.designpattern.Bridge;

/**
 * Created by hefeng on 17-9-14.
 */

public abstract class Coffee {

    protected ICoffeeAddictive addictive;

    Coffee(ICoffeeAddictive addictive)
    {
        this.addictive = addictive;
    }

    abstract void makeCoffee();

}
