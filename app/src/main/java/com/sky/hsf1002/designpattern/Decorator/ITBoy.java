package com.sky.hsf1002.designpattern.Decorator;

/**
 * Created by hefeng on 17-9-15.
 */

public class ITBoy extends PersonCloth {
    ITBoy(IPerson person) {
        super(person);
    }

    @Override
    public void dressed() {
        System.out.println("I am a IT boy.......................");
        super.dressed();

        wearTShirt();
        wearTrouses();
        wearSlipper();
    }

    private void wearTShirt()
    {
        System.out.println("TShirt.");
    }

    private void wearTrouses()
    {
        System.out.println("Trouses.");
    }

    private void wearSlipper()
    {
        System.out.println("Slipper.");
    }
}
