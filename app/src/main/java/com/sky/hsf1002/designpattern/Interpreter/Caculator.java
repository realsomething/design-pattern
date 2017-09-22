package com.sky.hsf1002.designpattern.Interpreter;

import java.util.Stack;

public class Caculator {
    private Stack<Expression> mExpStack = new Stack<>();

    public Caculator(String expression)
    {
        Expression expression0;
        Expression expression1;

        String [] elements = expression.split(" ");

        for (int i=0; i<elements.length; i++)
        {
            switch (elements[i].charAt(0))
            {
                case '+':
                    expression0 = mExpStack.pop();
                    expression1 = new NumberExpression(Integer.valueOf(elements[++i]));
                    mExpStack.push(new AddExpression(expression0, expression1));
                    break;
                case '-':
                    expression0 = mExpStack.pop();
                    expression1 = new NumberExpression(Integer.valueOf(elements[++i]));
                    mExpStack.push(new SubtractExpression(expression0, expression1));
                    break;
                case '*':
                    expression0 = mExpStack.pop();
                    expression1 = new NumberExpression(Integer.valueOf(elements[++i]));
                    mExpStack.push(new MultiplyExpression(expression0, expression1));
                    break;
                case '/':
                    expression0 = mExpStack.pop();
                    expression1 = new NumberExpression(Integer.valueOf(elements[++i]));
                    mExpStack.push(new DivideExpression(expression0, expression1));
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    mExpStack.push(new NumberExpression(Integer.valueOf(elements[i])));
                default:
                    continue;
            }
        }
    }

    public int caculate()
    {
        return mExpStack.pop().interpret();
    }
}
