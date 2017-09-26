package com.sky.hsf1002.designpattern.FactoryMethod;

public class Client {

    public static void main(String[] args) {
	    Factory factory = new FactoryCreateProductA();
	    IProduct iProduct;
		iProduct = factory.createProduct();
		iProduct.product();
	    factory = new FactoryCreateProductB();
		iProduct = factory.createProduct();
		iProduct.product();
    }
}
