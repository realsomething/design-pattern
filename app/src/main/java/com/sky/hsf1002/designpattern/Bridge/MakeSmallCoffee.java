package com.sky.hsf1002.designpattern.Bridge;

/**
 * Created by hefeng on 17-9-14.
 */

public class MakeSmallCoffee extends Coffee {
    MakeSmallCoffee(ICoffeeAddictive addictive) {
        super(addictive);
    }

    @Override
    void makeCoffee() {
        System.out.println("small & " + addictive.addSomething() + " coffee.");
    }
}
