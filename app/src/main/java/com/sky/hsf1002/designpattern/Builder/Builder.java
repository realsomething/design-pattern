package com.sky.hsf1002.designpattern.Builder;

public abstract class Builder {
    abstract Builder buildBoard(String board);
    abstract Builder buildOS(String os);
    abstract Builder buildInput(String input);
    abstract Builder buildOutput(String output);
    abstract Computer create();
}
