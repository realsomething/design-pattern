package com.sky.hsf1002.designpattern.State;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class NoonState extends State {
    @Override
    public void writeProgramme(Work work) {
        if (work.getHour() < 13)
        {
            System.out.println("noon: " + work.getHour() + ", have a break.");
        }
        else
        {
            work.setState(new AfternoonState());
            work.writeProgramme();
        }
    }
}
