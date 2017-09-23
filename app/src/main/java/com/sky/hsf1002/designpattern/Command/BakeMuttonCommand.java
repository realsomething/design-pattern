package com.sky.hsf1002.designpattern.Command;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class BakeMuttonCommand extends Command{

    public BakeMuttonCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    public void executeCommand() {
        barbecuer.bakeMutton();
    }
}
