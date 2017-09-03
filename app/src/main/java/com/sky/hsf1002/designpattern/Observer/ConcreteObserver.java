package com.sky.hsf1002.designpattern.Observer;

//import android.util.Log;

/**
 * Created by hsf1002 on 2017/9/3.
 */

public class ConcreteObserver extends Observer {
    //private static final String TAG = "ConcreteObserver";
    private String name;
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject, String name)
    {
        this.subject = subject;
        this.name = name;
    }

    @Override
    void update() {
        observerState = subject.getSubjectState();
        //Log.d(TAG, "update: " + name + "'s state is: " + observerState);
        System.out.println("update: " + name + ", stop talking.  " + observerState);
    }
}
