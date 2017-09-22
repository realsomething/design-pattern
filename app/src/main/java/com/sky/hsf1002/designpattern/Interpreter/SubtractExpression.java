package com.sky.hsf1002.designpattern.Interpreter;

public class SubtractExpression extends OperatorExpression{

    SubtractExpression(Expression expression0, Expression expression1)
    {
        super(expression0, expression1);
    }

    @Override
    public int interpret() {
        return expression0.interpret() - expression1.interpret();
    }
}
