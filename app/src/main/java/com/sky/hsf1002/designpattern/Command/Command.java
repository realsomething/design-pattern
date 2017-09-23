package com.sky.hsf1002.designpattern.Command;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public abstract class Command {
    protected Barbecuer barbecuer;

    public Command(Barbecuer barbecuer) {
        this.barbecuer = barbecuer;
    }

    public abstract void executeCommand();
}
