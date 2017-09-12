package com.sky.hsf1002.designpattern.FlyWeight;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by temp on 17-9-12.
 */

public class TicketFactory {

    private static Map<String, Ticket> sTicketMap = new ConcurrentHashMap<String, Ticket>();


    public static Ticket getTicket(String from, String to)
    {
        String key = from + "-" + to;

        if (sTicketMap.containsKey(key))
        {
            return sTicketMap.get(key);
        }
        else
        {
            Ticket ticket = new Ticket(from, to);
            sTicketMap.put(key, ticket);
            return ticket;
        }
    }
}
