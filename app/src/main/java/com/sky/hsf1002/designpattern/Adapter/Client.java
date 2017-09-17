package com.sky.hsf1002.designpattern.Adapter;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class Client {

    public static void main(String[] args)
    {
        Player player = new ForwardPlayer("Michael Jordan");
        player.attack();
        player.defense();

        player = new CenterPlayer("Shark");
        player.attack();
        player.defense();

        ForeignCenter foreignCenter = new ForeignCenter("Yao Ming");
        player = new Translator(foreignCenter);
        player.attack();
        player.defense();
    }
}
