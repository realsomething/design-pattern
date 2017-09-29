package com.sky.hsf1002.designpattern.Prototype;

public class Address {
    private String city;
    private String avenue;
    private String street;

    Address(String city, String avenue, String street)
    {
        this.city = city;
        this.avenue =avenue;
        this.street = street;
    }

    @Override
    public String toString() {
        return "city: " + city + ", avenue: " + avenue + ", street: " + street;
    }
}
