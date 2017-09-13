package com.sky.hsf1002.designpattern.FlyWeight;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by temp on 17-9-12.
 */

public class TicketFactory {

    private static Map<String, ITicket> sTicketMap = new ConcurrentHashMap<String, ITicket>();


    public static ITicket getTicket(String from, String to)
    {
        String key = from + "-" + to;

        if (sTicketMap.containsKey(key))
        {
            System.out.println("use cache:   from " + from + "  to  " + to);
            return sTicketMap.get(key);
        }
        else
        {
            Ticket ticket = new Ticket(from, to);
            System.out.println("new ticket:  from " + from + "  to  " + to);
            sTicketMap.put(key, ticket);
            return ticket;
        }
    }
}
