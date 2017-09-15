package com.sky.hsf1002.designpattern.Decorator;

/**
 * Created by hefeng on 17-9-15.
 */

public class PersonCloth extends Person{
    private IPerson person;

    PersonCloth(IPerson person)
    {
        this.person = person;
    }

    @Override
    public void dressed() {
        person.dressed();
    }
}
