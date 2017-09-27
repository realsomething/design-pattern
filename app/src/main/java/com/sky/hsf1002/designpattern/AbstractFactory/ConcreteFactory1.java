package com.sky.hsf1002.designpattern.AbstractFactory;

public class ConcreteFactory1 extends Factory{
    @Override
    IProductA createProductA() {
        return new ProductA1();
    }

    @Override
    IProductB createProductB() {
        return new ProductB1();
    }
}
