package com.sky.hsf1002.designpattern.Iterator;


import java.util.List;

public class MinIterator implements IIterator{
    private List<Employee> list;
    private int position;

    MinIterator(List<Employee> list)
    {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (position >=0 && position <= list.size() - 1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Employee employee = list.get(position);
        position++;

        return employee;
    }
}
