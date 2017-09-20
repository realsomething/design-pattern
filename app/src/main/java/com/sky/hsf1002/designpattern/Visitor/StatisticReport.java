package com.sky.hsf1002.designpattern.Visitor;

import java.util.LinkedList;
import java.util.List;

public class StatisticReport {
    private List<Staff>  staffs = new LinkedList<>();

    StatisticReport()
    {
        staffs.add(new Manager("vinent", 1));
        staffs.add(new Manager("roger", 2));
        staffs.add(new Employee("sky", 3));
        staffs.add(new Employee("andy", 4));
    }


    public void showReport(IVisitor visitor)
    {
        for (Staff staff: staffs)
        {
            staff.accept(visitor);
        }
    }
}
