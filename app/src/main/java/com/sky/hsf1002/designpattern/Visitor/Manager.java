package com.sky.hsf1002.designpattern.Visitor;

import java.util.Random;

public class Manager extends Staff {

    private int productNumber;

    Manager(String name, int kpi) {
        super(name, kpi);
        productNumber = new Random().nextInt(10);
    }

    public int getProductNumber() {
        return productNumber;
    }

    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
