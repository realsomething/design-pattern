package com.sky.hsf1002.designpattern.Builder;

public class Client {

    public static void main(String[] args) {
        Builder builder = new MacBuilder();
        Computer computer = builder.buildInput("keyboard").buildOutput("display").create();
        System.out.println(computer);

        builder = new WindowBuilder();
        computer = builder.buildInput("mouse").buildOutput("display").create();
        System.out.println(computer);
    }
}
