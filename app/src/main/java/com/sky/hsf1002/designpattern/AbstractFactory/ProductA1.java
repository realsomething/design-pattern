package com.sky.hsf1002.designpattern.AbstractFactory;

public class ProductA1 implements IProductA {
    ProductA1()
    {
        System.out.println("ProductA1---creating---------------------------");
    }

    @Override
    public void createPartA1() {
        System.out.println("---createPartA1");
    }

    @Override
    public void createPartA2() {
        System.out.println("---createPartA2");
    }
}
