package com.sky.hsf1002.designpattern.State;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class ForenoonState extends State{
    @Override
    public void writeProgramme(Work work) {
        if (work.getHour() < 12)
        {
            System.out.println("forenoon: " + work.getHour() + ", keep on working.");
        }
        else
        {
            work.setState(new NoonState());
            work.writeProgramme();
        }
    }
}
