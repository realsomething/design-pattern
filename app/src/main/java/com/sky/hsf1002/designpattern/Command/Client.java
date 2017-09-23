package com.sky.hsf1002.designpattern.Command;

public class Client {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Barbecuer barbecuer = new Barbecuer();
        Command command = new BakeMuttonCommand(barbecuer);
        waiter.setCommand(command);
        command = new BakeChickenWingCommand(barbecuer);
        waiter.setCommand(command);
        command = new BakeChickenWingCommand(barbecuer);
        waiter.setCommand(command);

        waiter.notifyCommands();
    }
}
