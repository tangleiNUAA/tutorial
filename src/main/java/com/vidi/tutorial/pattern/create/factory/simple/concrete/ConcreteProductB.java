package com.vidi.tutorial.pattern.create.factory.simple.concrete;

import com.vidi.tutorial.pattern.create.factory.simple.Product;

public class ConcreteProductB implements Product {
    @Override
    public void method() {
        System.out.println("method in ConCreteProductB");
    }
}
