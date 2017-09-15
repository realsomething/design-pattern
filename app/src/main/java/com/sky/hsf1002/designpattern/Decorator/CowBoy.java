package com.sky.hsf1002.designpattern.Decorator;

/**
 * Created by hefeng on 17-9-15.
 */

public class CowBoy extends PersonCloth {

    CowBoy(IPerson person) {
        super(person);
    }

    @Override
    public void dressed() {
        System.out.println("I am a Cowboy..............................");
        super.dressed();
        wearHat();
        wearJeans();

    }

    private void wearHat()
    {
        System.out.println("hat.");
    }

    private void wearJeans()
    {
        System.out.println("Jeans.");
    }
}
