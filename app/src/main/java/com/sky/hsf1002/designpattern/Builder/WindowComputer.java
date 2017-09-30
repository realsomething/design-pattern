package com.sky.hsf1002.designpattern.Builder;

public class WindowComputer extends Computer{
    // essential
    WindowComputer(String board, String os)
    {
        this.board = board;
        this.os = os;
    }

    @Override
    void setBoard(String board) {
        this.board = board;
    }

    @Override
    void setOs(String os) {
        this.os = os;
    }

    @Override
    void setInput(String input) {
        this.input = input;
    }

    @Override
    void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Window computer board: " + board + ", os: " + os + ", input: " + input + ", output: " + output;
    }
}
