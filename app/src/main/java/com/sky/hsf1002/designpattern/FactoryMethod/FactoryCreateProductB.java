package com.sky.hsf1002.designpattern.FactoryMethod;

public class FactoryCreateProductB extends Factory{
    @Override
    IProduct createProduct() {
        return new ConcreteProductB();
    }
}
