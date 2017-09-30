package com.sky.hsf1002.designpattern.Builder;

public class Client {

    public static void main(String[] args) {
        Computer computer = new MacComputer("Apple", "Mac");
	    computer.setInput("keyboard").setOutput("display");
	    System.out.println(computer);

        computer = new WindowComputer("Window", "Win10");
        computer.setInput("mouse").setOutput("display");
        System.out.println(computer);
    }
}
