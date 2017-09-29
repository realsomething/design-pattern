package com.sky.hsf1002.designpattern.Prototype;

public class Address implements Cloneable{
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

    @Override
    protected Object clone(){
        Address address_clone = null;

        try {
            address_clone = (Address)super.clone();
            address_clone.city = "beijing";
            address_clone.avenue = "wudaokou";
            address_clone.street = "universecenter";
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return address_clone;
    }
}
