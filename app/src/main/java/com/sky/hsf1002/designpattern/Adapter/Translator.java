package com.sky.hsf1002.designpattern.Adapter;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class Translator extends Player{

    ForeignCenter foreignCenter;

    Translator(ForeignCenter foreignCenter)
    {
        this.foreignCenter = foreignCenter;
    }

    @Override
    void attack() {
        System.out.println("translator: ");
        foreignCenter.attack();
    }

    @Override
    void defense() {
        System.out.println("translator: ");
        foreignCenter.defense();
    }
}
