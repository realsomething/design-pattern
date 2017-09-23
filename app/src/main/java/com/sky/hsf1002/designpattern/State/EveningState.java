package com.sky.hsf1002.designpattern.State;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class EveningState extends State{
    @Override
    public void writeProgramme(Work work) {
        if (work.isFinished())
        {
            work.setState(new RestState());
            work.writeProgramme();
        }
        else
        {
            if (work.getHour() < 22)
            {
                System.out.println("evening: " + work.getHour() + ", keep on working.");
            }
            else
            {
                work.setState(new SleepingState());
                work.writeProgramme();
            }
        }
    }
}
