package com.vidi.tutorial.pattern.create.factory.simple;

import com.vidi.tutorial.pattern.create.factory.simple.concrete.ConcreteProductA;
import com.vidi.tutorial.pattern.create.factory.simple.concrete.ConcreteProductB;

public class Factory {
    public static Product getProduct(String arg) {
        Product product = null;
        switch (arg) {
            case "A":
                product = new ConcreteProductA();
                break;
            case "B":
                product = new ConcreteProductB();
                break;
            default:
                return null;
        }

        return product;
    }
}
