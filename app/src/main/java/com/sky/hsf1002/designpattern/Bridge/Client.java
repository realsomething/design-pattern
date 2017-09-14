package com.sky.hsf1002.designpattern.Bridge;

/**
 * Created by temp on 17-9-13.
 */

public class Client {

     public static void main(String[] args) {
        ICoffeeAddictive addictive = new OriginalCoffee();
        Coffee coffee = new MakeBigCoffee(addictive);
        coffee.makeCoffee();

        addictive = new SugarCoffee();
        coffee = new MakeBigCoffee(addictive);
        coffee.makeCoffee();

        addictive = new OriginalCoffee();
        coffee = new MakeSmallCoffee(addictive);
        coffee.makeCoffee();

        addictive = new SugarCoffee();
        coffee = new MakeSmallCoffee(addictive);
        coffee.makeCoffee();
    }

}