package com.sky.hsf1002.designpattern.State;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class RestState extends State{
    @Override
    public void writeProgramme(Work work) {
        System.out.println("work finished: " + work.getHour() + ", go home.");
    }
}
