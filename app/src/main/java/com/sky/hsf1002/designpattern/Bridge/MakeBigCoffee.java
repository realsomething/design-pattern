package com.sky.hsf1002.designpattern.Bridge;

/**
 * Created by hefeng on 17-9-14.
 */

public class MakeBigCoffee extends Coffee {

    MakeBigCoffee(ICoffeeAddictive addictive) {
        super(addictive);
    }

    @Override
    void makeCoffee() {
        System.out.println("big & " + addictive.addSomething() + " coffee.");
    }
}
