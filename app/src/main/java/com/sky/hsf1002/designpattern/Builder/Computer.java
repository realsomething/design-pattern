package com.sky.hsf1002.designpattern.Builder;

public abstract class Computer {
    protected String board;
    protected String os;
    protected String input;
    protected String output;

    abstract Computer setBoard(String board);
    abstract Computer setOs(String os);
    abstract Computer setInput(String input);
    abstract Computer setOutput(String output);
}
