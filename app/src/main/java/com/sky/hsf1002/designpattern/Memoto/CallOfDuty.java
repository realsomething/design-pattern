package com.sky.hsf1002.designpattern.Memoto;

import jdk.nashorn.internal.codegen.CompilerConstants;

public class CallOfDuty {
    private int level;
    private int lifeValue;
    private String weapon;

    CallOfDuty(int level, int lifeValue, String weapon)
    {
        this.level = level;
        this.lifeValue = lifeValue;
        this.weapon = weapon;
    }

    CallOfDuty()
    {

    }


    public void play()
    {
        System.out.println("playing......... " + this);
        level++;
        lifeValue++;
        weapon = "sword";
    }

    public void quit()
    {
        System.out.println("quit............ " + this);
    }

    public Memoto save()
    {
        Memoto memoto = new Memoto();
        memoto.level = level;
        memoto.lifeValue = lifeValue;
        memoto.weapon = weapon;

        return memoto;
    }

    public void restore(Memoto memoto)
    {
        level = memoto.level;
        lifeValue = memoto.lifeValue;
        weapon = memoto.weapon;

        System.out.println("last state...... " + this);
    }

    @Override
    public String toString() {
        return "levle: " + level + ", lifeValue: " + lifeValue + ", weapon: " + weapon;
    }
}
