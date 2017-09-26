package com.sky.hsf1002.designpattern.FactoryMethod;

public class Client {

    public static void main(String[] args) {
	    Factory factory = new FactoryCreateProduct();
	    IProduct iProduct;
		iProduct = factory.createProduct(ConcreteProductA.class);
		iProduct.product();

        iProduct = factory.createProduct(ConcreteProductB.class);
		iProduct.product();
    }
}
