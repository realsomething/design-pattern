package com.sky.hsf1002.designpattern.Proxy.StaticProxy;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class Lawyer implements ILawsuit {
    private ILawsuit customer;

    Lawyer(ILawsuit customer)
    {
        this.customer = customer;
    }

    @Override
    public void summit() {
        System.out.print("lawyer proxy: ");
        customer.summit();
    }

    @Override
    public void burden() {
        System.out.print("lawyer proxy: ");
        customer.burden();
    }

    @Override
    public void defend() {
        System.out.print("lawyer proxy: ");
        customer.defend();
    }

    @Override
    public void finish() {
        System.out.print("lawyer proxy: ");
        customer.finish();
    }
}
