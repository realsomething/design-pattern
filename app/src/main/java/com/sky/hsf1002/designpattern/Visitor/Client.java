package com.sky.hsf1002.designpattern.Visitor;

public class Client {

    public static void main(String []args)
    {
        VisitorCEO ceo = new VisitorCEO();
        VisitorCTO cto = new VisitorCTO();

        StatisticReport sr = new StatisticReport();
        sr.showReport(ceo);
        sr.showReport(cto);
    }
}
