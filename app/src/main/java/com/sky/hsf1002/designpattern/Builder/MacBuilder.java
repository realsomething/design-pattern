package com.sky.hsf1002.designpattern.Builder;

public class MacBuilder extends Builder{
    MacComputer computer;

    MacBuilder()
    {
        this.computer = new MacComputer("Apple", "MAC");
    }

    @Override
    Builder buildBoard(String board) {
        computer.setBoard(board);
        return this;
    }

    @Override
    Builder buildOS(String os) {
        computer.setOs(os);
        return this;
    }

    @Override
    Builder buildInput(String input) {
        computer.setInput(input);
        return this;
    }

    @Override
    Builder buildOutput(String output) {
        computer.setOutput(output);
        return this;
    }

    @Override
    MacComputer create() {
        return computer;
    }
}
