package com.sky.hsf1002.designpattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsf1002 on 2017/9/3.
 */

public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    public void registerObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void notifyObserver()
    {
        for (Observer observer:observers)
        {
            observer.update();
        }
    }
}
