package com.sky.hsf1002.designpattern.Interpreter;

public class DivideExpression extends OperatorExpression{
    DivideExpression(Expression expression0, Expression expression1)
    {
        super(expression0, expression1);
    }

    @Override
    public int interpret() {
        if (expression1.interpret() == 0)
        {
            return 2147483647;
        }

        return expression0.interpret() / expression1.interpret();
    }
}
