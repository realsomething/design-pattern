package com.sky.hsf1002.designpattern.AbstractFactory;

public class Client {

    public static void main(String[] args) {
        Factory factory = new ConcreteFactory1();
        IProductA productA = factory.createProductA();
        productA.createPartA1();
        productA.createPartA2();

        IProductB productB = factory.createProductB();
        productB.createPartB1();
        productB.createPartB2();

        factory = new ConcreteFactory2();
        productA = factory.createProductA();
        productA.createPartA1();
        productA.createPartA2();

        productB = factory.createProductB();
        productB.createPartB1();
        productB.createPartB2();
    }
}
