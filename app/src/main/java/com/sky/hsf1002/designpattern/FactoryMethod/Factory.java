package com.sky.hsf1002.designpattern.FactoryMethod;

public abstract class Factory {
    abstract <T extends IProduct> T createProduct(Class<T> clz);
}
