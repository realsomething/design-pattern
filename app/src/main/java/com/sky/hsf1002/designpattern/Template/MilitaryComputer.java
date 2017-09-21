package com.sky.hsf1002.designpattern.Template;

public class MilitaryComputer extends Computor{

    MilitaryComputer()
    {
        System.out.println("--------------------------MilitaryComputer--------------------------");

    }
    @Override
    protected void checkHardware() {
        super.checkHardware();

        System.out.println("check hardware fireware...");
    }

    @Override
    protected void login() {
        System.out.println("login check fingerprint...");
    }
}
