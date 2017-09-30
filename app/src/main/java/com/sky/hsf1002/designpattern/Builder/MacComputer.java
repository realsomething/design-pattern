package com.sky.hsf1002.designpattern.Builder;

public class MacComputer extends Computer{

    // essential
    MacComputer(String board, String os)
    {
        this.board = board;
        this.os = os;
    }

    @Override
    Computer setBoard(String board) {
        this.board = board;
        return this;
    }

    @Override
    Computer setOs(String os) {
        this.os = os;
        return this;
    }

    @Override
    Computer setInput(String input) {
        this.input = input;
        return this;
    }

    @Override
    Computer setOutput(String output) {
        this.output = output;
        return this;
    }

    @Override
    public String toString() {
        return "Mac computer board: " + board + ", os: " + os + ", input: " + input + ", output: " + output;
    }
}
