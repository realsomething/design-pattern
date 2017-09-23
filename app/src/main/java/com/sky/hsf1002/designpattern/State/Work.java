package com.sky.hsf1002.designpattern.State;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class Work {

    private State state;
    private int hour;
    private boolean isFinished;

    public void setState(State state) {
        this.state = state;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void writeProgramme()
    {
        state.writeProgramme(this);
    }
}
