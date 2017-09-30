package com.sky.hsf1002.designpattern.Builder;

public abstract class Computer {
    protected String board;
    protected String os;
    protected String input;
    protected String output;

    abstract void setBoard(String board);
    abstract void setOs(String os);
    abstract void setInput(String input);
    abstract void setOutput(String output);
}
