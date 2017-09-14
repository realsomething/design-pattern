package com.sky.hsf1002.designpattern.Bridge;

/**
 * Created by temp on 17-9-13.
 */

public class SugarCoffee implements ICoffeeAddictive {

    @Override
    public String addSomething() {
        return "sugar";
    }
}
