package com.sky.hsf1002.designpattern.Template;

public abstract class Computor {

    protected void powerOn()
    {
        System.out.println("power on...");
    }

    protected void checkHardware()
    {
        System.out.println("check hardware...");
    }

    protected void loadSystemOS()
    {
        System.out.println("load system os...");
    }

    protected void login()
    {
        System.out.println("login...");
    }

    public final void startUp()
    {
        powerOn();
        checkHardware();
        loadSystemOS();
        login();
    }
}
