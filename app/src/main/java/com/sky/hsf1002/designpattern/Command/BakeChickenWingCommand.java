package com.sky.hsf1002.designpattern.Command;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class BakeChickenWingCommand extends Command{
    public BakeChickenWingCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    public void executeCommand() {
        barbecuer.bakeChickenWing();
    }
}
