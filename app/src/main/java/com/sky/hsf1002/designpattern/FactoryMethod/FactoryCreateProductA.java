package com.sky.hsf1002.designpattern.FactoryMethod;

public class FactoryCreateProductA extends Factory{
    @Override
    IProduct createProduct() {
        return  new ConcreteProductA();
    }
}
