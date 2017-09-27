package com.sky.hsf1002.designpattern.AbstractFactory;

public class ProductB1 implements IProductB {
    ProductB1()
    {
        System.out.println("ProductB1---creating---------------------------");
    }

    @Override
    public void createPartB1() {
        System.out.println("---createPartB1");
    }

    @Override
    public void createPartB2() {
        System.out.println("---createPartB2");
    }
}
