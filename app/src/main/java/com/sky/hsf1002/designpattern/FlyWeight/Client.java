package com.sky.hsf1002.designpattern.FlyWeight;

/**
 * Created by temp on 17-9-12.
 */

public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Ticket t1 = TicketFactory.getTicket("ShenZhen", "Xi'An");
        Ticket t2 = TicketFactory.getTicket("ShenZhen", "Xi'An");
        Ticket t3 = TicketFactory.getTicket("ShenZhen", "BeiJing");
        Ticket t4 = TicketFactory.getTicket("ShenZhen", "ShangHai");

        System.out.println("t1 == t2 : " +  (t1 == t2));	// true;
        System.out.println("t1 == t3 : " +  (t1 == t3));	// false;
        System.out.println("t1 == t4 : " +  (t1 == t4));    // false;
    }

}
