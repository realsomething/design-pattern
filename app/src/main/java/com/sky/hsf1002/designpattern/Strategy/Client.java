package com.sky.hsf1002.designpattern.Strategy;

public class Client {

    public static void main(String[] args) {
	    IStrategy iStrategy;
	    Person person = new Person();

        iStrategy = new BusStrategy();
        person.setDistance(20);
        person.setStrategy(iStrategy);
        person.price();

        iStrategy = new CarStrategy();
        person.setStrategy(iStrategy);
        person.price();

        iStrategy = new SubwayStrategy();
        person.setStrategy(iStrategy);
        person.price();
    }
}
