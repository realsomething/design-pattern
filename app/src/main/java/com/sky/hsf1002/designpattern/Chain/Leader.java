package com.sky.hsf1002.designpattern.Chain;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public abstract class Leader {
    private Leader nextHandler;

    public final void handleRequest(int money)
    {
        if (money <= limit())
        {
            handle(money);
        }
        else
        {
            if (nextHandler != null) {
                nextHandler.handleRequest(money);
            }
        }
    }

    public void setNextHandler(Leader nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract int limit();
    protected abstract void handle(int money);
}
