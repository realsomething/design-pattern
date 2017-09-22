package com.sky.hsf1002.designpattern.Iterator;

public class Employee {
    private String name;
    private int age;

    Employee(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
