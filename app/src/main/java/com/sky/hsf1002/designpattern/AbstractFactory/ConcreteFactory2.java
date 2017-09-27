package com.sky.hsf1002.designpattern.AbstractFactory;

public class ConcreteFactory2 extends Factory{
    @Override
    IProductA createProductA() {
        return new ProductA2();
    }

    @Override
    IProductB createProductB() {
        return new ProductB2();
    }
}
