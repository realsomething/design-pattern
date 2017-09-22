package com.sky.hsf1002.designpattern.Iterator;

import java.util.ArrayList;
import java.util.List;

public class MinCompany implements ICompany{

    private List<Employee> list;

    MinCompany()
    {
        list = new ArrayList<>();
        list.add(new Employee("sky", 25));
        list.add(new Employee("lotus", 24));
        list.add(new Employee("chery", 23));
    }

    @Override
    public IIterator iterator() {
        return new MinIterator(list);
    }
}
