package com.sky.hsf1002.designpattern.Strategy;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class Person {
    private IStrategy strategy;
    private int distance;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void price()
    {
        int price = strategy.price(distance);
        System.out.println("distance: " + distance + ", price: " + price);
    }
}
