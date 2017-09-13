package com.sky.hsf1002.designpattern.FlyWeight;

import java.util.Random;

/**
 * Created by temp on 17-9-12.
 */

public class Ticket implements ITicket {

    private  String from;
    private  String to;

    Ticket(String from, String to)
    {
        this.from = from;
        this.to = to;
    }

    public void showTicketInfo(String type) {
        // TODO Auto-generated method stub
        int price = new Random().nextInt(100);

        System.out.println("ticket from " + from + "   to  " + to +",  type:  " + type + "  price:  " + price );
    }
}
