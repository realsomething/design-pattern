package com.sky.hsf1002.designpattern.Template;

public class Coder extends Computor {

    Coder()
    {
        System.out.println("--------------------------Coder--------------------------");
    }


    @Override
    protected void login() {
        System.out.println("login input username and passward...");
    }
}
