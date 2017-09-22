package com.sky.hsf1002.designpattern.Interpreter;

public class Client {

    public static void main(String[] args) {
        String expressiono = "11 + 22 + 33 - 44 = ";
        Caculator caculator = new Caculator(expressiono);
        System.out.println(expressiono + caculator.caculate());

        String expression1 = "11 * 22 * 33 / 44 = ";
        caculator = new Caculator(expression1);
        System.out.println(expression1 + caculator.caculate());
    }
}
