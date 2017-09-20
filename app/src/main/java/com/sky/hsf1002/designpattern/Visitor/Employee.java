package com.sky.hsf1002.designpattern.Visitor;

import java.util.Random;

public class Employee extends Staff{

    private long codeNumbe;

    Employee(String name, int kpi)
    {
        super(name, kpi);
        codeNumbe = new Random().nextInt(10000*10);

    }

    public long getCodeNumbe() {
        return codeNumbe;
    }

    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }

}
