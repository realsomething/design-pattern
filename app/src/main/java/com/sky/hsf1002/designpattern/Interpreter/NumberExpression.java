package com.sky.hsf1002.designpattern.Interpreter;

public class NumberExpression extends Expression{
    private int num;

    NumberExpression(int num)
    {
        this.num = num;
    }

    @Override
    public int interpret() {
        return num;
    }
}
