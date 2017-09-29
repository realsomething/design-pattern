package com.sky.hsf1002.designpattern.Prototype;

public class User implements Cloneable{
    private String name;
    private int age;
    private Address address;

    User()
    {
        this.name = "default";
        this.age = 1024;
        this.address = new Address("beijing", "wudaokou", "UniverseCenter");
    }

    User(String name, int age, Address address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    protected Object clone() {
        User userClone = new User();

        return userClone;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age + "\n" + address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
