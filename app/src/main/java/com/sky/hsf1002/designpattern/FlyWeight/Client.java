package com.sky.hsf1002.designpattern.FlyWeight;

/**
 * Created by temp on 17-9-12.
 */

public class Client {
    public static void main(String[] args) {
        //  inner state (from, to) is stable
        ITicket t1 = TicketFactory.getTicket("ShenZhen", "Xi'An");
        ITicket t2 = TicketFactory.getTicket("ShenZhen", "Xi'An");
        ITicket t3 = TicketFactory.getTicket("ShenZhen", "BeiJing");
        ITicket t4 = TicketFactory.getTicket("ShenZhen", "ShangHai");

        System.out.println("t1 == t2 : " + (t1 == t2));    // true;
        System.out.println("t1 == t3 : " + (t1 == t3));    // false;
        System.out.println("t1 == t4 : " + (t1 == t4));  // false;

        // outer state(type, price) is variable
        t1.showTicketInfo("ShangPuYingWo");
        t2.showTicketInfo("ShangPuRuanWo");
        t3.showTicketInfo("XiaPuYingWo");
        t4.showTicketInfo("XiaPuRuanWo");
    }
}
