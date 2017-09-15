package com.sky.hsf1002.designpattern.Decorator;

/**
 * Created by hefeng on 17-9-15.
 */

public class Client {

    public static void main(String[] args) {

        Person person = new Person();

        IPerson p = new CowBoy(person);
        p.dressed();

        p = new ITBoy(person);
        p.dressed();
    }
}
