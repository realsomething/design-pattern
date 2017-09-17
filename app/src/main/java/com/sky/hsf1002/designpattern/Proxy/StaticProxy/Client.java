package com.sky.hsf1002.designpattern.Proxy.StaticProxy;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class Client {
    public static void main(String [] args)
    {
        ILawsuit customer = new Customer("xiaoming");
        ILawsuit lawyer = new Lawyer(customer);

        lawyer.summit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }
}
