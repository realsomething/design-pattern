package com.sky.hsf1002.designpattern.Visitor;

public class VisitorCTO implements IVisitor {
    @Override
    public void visit(Employee employee) {
        System.out.println("CTO focus employee name: " + employee.name + ", code number: " + employee.getCodeNumbe());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("CTO focus manager name: " + manager.name + ", product number: " + manager.getProductNumber());
    }
}
