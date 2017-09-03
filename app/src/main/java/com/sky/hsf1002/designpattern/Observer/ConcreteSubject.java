package com.sky.hsf1002.designpattern.Observer;

/**
 * Created by hsf1002 on 2017/9/3.
 */

public class ConcreteSubject extends Subject {
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
