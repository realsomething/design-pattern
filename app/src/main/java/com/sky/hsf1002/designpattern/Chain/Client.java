package com.sky.hsf1002.designpattern.Chain;

public class Client {

    public static void main(String[] args) {
	    GroupLeader groupLeader = new GroupLeader();
	    Director director = new Director();
	    Manager manager = new Manager();
	    Boss boss = new Boss();
	    groupLeader.setNextHandler(director);
	    director.setNextHandler(manager);
	    manager.setNextHandler(boss);

	    groupLeader.handleRequest(40000);
		groupLeader.handleRequest(100000);
    }
}
