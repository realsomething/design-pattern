package com.sky.hsf1002.designpattern.Visitor;

public class VisitorCEO implements IVisitor{
    @Override
    public void visit(Employee employee) {
        System.out.println("CEO focus employee name: " + employee.name + ", kpi: " + employee.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("CEO focus manager name: " + manager.name + ", kpi: " + manager.kpi);
    }
}
