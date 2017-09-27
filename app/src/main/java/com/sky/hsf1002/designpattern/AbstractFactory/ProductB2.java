package com.sky.hsf1002.designpattern.AbstractFactory;

public class ProductB2 implements IProductB{
    ProductB2()
    {
        System.out.println("ProductB2---creating---------------------------");
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
