package com.sky.hsf1002.designpattern.Observer;

/**
 * Created by hsf1002 on 2017/9/3.
 */

public class client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver co1 = new ConcreteObserver(subject, "sky");
        ConcreteObserver co2 = new ConcreteObserver(subject, "lotus");
        subject.registerObserver(co1);
        subject.registerObserver(co2);
        subject.setSubjectState("boss is coming!");
        subject.notifyObserver();
    }
}