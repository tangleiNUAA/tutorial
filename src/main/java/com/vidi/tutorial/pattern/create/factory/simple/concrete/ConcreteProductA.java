package com.vidi.tutorial.pattern.create.factory.simple.concrete;

import com.vidi.tutorial.pattern.create.factory.simple.Product;

public class ConcreteProductA implements Product {

    @Override
    public void method() {
        System.out.println("method in ConCreteProductA");
    }
}
