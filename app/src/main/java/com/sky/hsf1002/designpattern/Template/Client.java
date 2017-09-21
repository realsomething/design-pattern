package com.sky.hsf1002.designpattern.Template;

public class Client {

    public static void main(String[] args) {

        GreenHand greenHand = new GreenHand();
        greenHand.startUp();

        Coder coder = new Coder();
        coder.startUp();

        MilitaryComputer militaryComputer = new MilitaryComputer();
        militaryComputer.startUp();
    }
}
