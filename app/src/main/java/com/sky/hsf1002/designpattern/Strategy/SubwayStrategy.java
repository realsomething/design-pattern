package com.sky.hsf1002.designpattern.Strategy;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class SubwayStrategy implements IStrategy{
    SubwayStrategy()
    {
        System.out.print("Subway ");
    }

    @Override
    public int price(int distance) {

        if (distance < 10)
        {
            return 3;
        }
        else
        {
            return (distance - 10) * 1 + 3;
        }
    }
}
