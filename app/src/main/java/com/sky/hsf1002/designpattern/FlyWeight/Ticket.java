package com.sky.hsf1002.designpattern.FlyWeight;

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

    public void showTicketInfo(String from, String to) {
        // TODO Auto-generated method stub
        System.out.println("ticket from: " + from + "   to  " + to );
    }
}
