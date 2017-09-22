package com.sky.hsf1002.designpattern.Iterator;

public class HuiIterator implements IIterator {
    private Employee[] employees;
    private int position;
    private int realSize;

    HuiIterator(Employee[] employees, int realSize)
    {
        this.employees = employees;
        this.realSize = realSize;
    }

    @Override
    public boolean hasNext() {
        if (position >=0 && position < realSize)
        {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Employee employee = employees[position];
        position++;

        return employee;
    }
}
