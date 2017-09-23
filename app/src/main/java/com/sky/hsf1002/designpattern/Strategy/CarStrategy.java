package com.sky.hsf1002.designpattern.Strategy;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class CarStrategy implements IStrategy{
    CarStrategy()
    {
        System.out.print("Car ");
    }

    @Override
    public int price(int distance) {
        return distance * 2;
    }
}
