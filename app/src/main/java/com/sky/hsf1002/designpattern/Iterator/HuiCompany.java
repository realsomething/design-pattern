package com.sky.hsf1002.designpattern.Iterator;

public class HuiCompany implements ICompany{
    private Employee[] employees;
    private final static int size = 10;

    HuiCompany()
    {
        employees = new Employee[size];
        employees[0] = new Employee("min", 55);
        employees[1] = new Employee("hui", 44);
        employees[2] = new Employee("feng", 33);
    }

    @Override
    public IIterator iterator() {
        return new HuiIterator(employees, realSize());
    }


    private int realSize()
    {
        Employee employee;
        int realSize = 0;

        for (int i=0; i<size; i++)
        {
            employee = employees[i];

            if ((employee==null) || (employee.getName().equals("") && employee.getAge() == 0))
            {
                continue;
            }
            else
            {
                realSize++;
            }
        }

        return realSize;
    }
}
