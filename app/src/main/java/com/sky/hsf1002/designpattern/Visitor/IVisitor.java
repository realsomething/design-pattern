package com.sky.hsf1002.designpattern.Visitor;

public interface IVisitor {
    void visit(Employee employee);
    void visit(Manager manager);
}
