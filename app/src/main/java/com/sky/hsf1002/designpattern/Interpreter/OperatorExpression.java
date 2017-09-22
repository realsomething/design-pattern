package com.sky.hsf1002.designpattern.Interpreter;

public abstract class OperatorExpression extends Expression{
    protected Expression expression0;
    protected Expression expression1;

    OperatorExpression(Expression expression0, Expression expression1)
    {
        this.expression0 = expression0;
        this.expression1 = expression1;
    }
}
