package com.sky.hsf1002.designpattern.Decorator;

/**
 * Created by hefeng on 17-9-15.
 */

public class Person implements IPerson {


    @Override
    public void dressed() {
        wearUnderwear();
    }

    private void wearUnderwear()
    {
        System.out.println("underwear.");
    }
}
