package com.sky.hsf1002.designpattern.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsf1002 on 2017/9/23.
 */
public class Waiter {

    private List<Command> commands;

    Waiter()
    {
        commands = new ArrayList<>();
    }

    public void setCommand(Command command)
    {
        commands.add(command);
    }

    public void notifyCommands()
    {
        for (Command command:commands)
        {
            command.executeCommand();
        }
    }
}
