package com.sky.hsf1002.designpattern.Visitor;

public abstract class Staff {
    protected String name;
    protected int kpi;

    Staff(String name, int kpi)
    {
        this.name = name;
        this.kpi = kpi;
    }

    abstract void accept(IVisitor visitor);
}
