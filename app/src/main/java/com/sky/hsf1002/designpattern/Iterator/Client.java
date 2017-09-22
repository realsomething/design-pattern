package com.sky.hsf1002.designpattern.Iterator;

public class Client {

    public static void main(String[] args) {
        IIterator iIterator;

        MinCompany minCompany = new MinCompany();
        iIterator = minCompany.iterator();
        System.out.println("--------------------------Min company--------------------------");
        printEmployeeInfo(iIterator);


        HuiCompany huiCompany = new HuiCompany();
        iIterator = huiCompany.iterator();
        System.out.println("--------------------------Hui company--------------------------");
        printEmployeeInfo(iIterator);
    }

    private static void printEmployeeInfo(IIterator iIterator)
    {
        while (iIterator.hasNext())
        {
            System.out.println(iIterator.next());
        }
    }
}
