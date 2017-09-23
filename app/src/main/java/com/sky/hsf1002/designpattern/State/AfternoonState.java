package com.sky.hsf1002.designpattern.State;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class AfternoonState extends State{
    @Override
    public void writeProgramme(Work work) {
        if (work.getHour() < 17)
        {
            System.out.println("afternoon: " + work.getHour() + ", keep on working.");
        }
        else
        {
            work.setState(new EveningState());
            work.writeProgramme();
        }
    }
}
