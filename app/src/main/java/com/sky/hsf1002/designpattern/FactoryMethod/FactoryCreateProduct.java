package com.sky.hsf1002.designpattern.FactoryMethod;

import javax.swing.*;

public class FactoryCreateProduct extends Factory{
    @Override
    <T extends IProduct> T createProduct(Class<T> clz) {
        IProduct iProduct = null;

        try
        {
            iProduct = (IProduct)Class.forName(clz.getName()).newInstance();
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }

        return (T)iProduct;
    }
}
