package com.sky.hsf1002.designpattern.State;

import java.util.Random;

public class Client {

    public static void main(String[] args) {
        Work work = new Work();
        State state = new ForenoonState();

        for (int i=0; i<8; i++)
        {
            work.setHour(new Random().nextInt(24));
            state.writeProgramme(work);
        }

        work.setFinished(true);
        state.writeProgramme(work);
    }
}
