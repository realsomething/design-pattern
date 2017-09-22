package com.sky.hsf1002.designpattern.Memoto;

public class Client {

    public static void main(String[] args) {
        CallOfDuty player = new CallOfDuty(1, 2, "gun");
        player.play();

        CareTaker careTaker = new CareTaker();
        careTaker.setMemoto(player.save());

        player.quit();

        CallOfDuty player1 = new CallOfDuty();
        player1.restore(careTaker.getMemoto());
    }
}
