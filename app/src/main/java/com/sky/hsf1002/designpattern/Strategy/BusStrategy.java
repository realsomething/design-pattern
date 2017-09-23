package com.sky.hsf1002.designpattern.Strategy;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class BusStrategy implements IStrategy{
    BusStrategy()
    {
        System.out.print("Bus ");
    }

    @Override
    public int price(int distance) {
        if (distance < 10)
        {
            return 2;
        }
        return 3;
    }
}
