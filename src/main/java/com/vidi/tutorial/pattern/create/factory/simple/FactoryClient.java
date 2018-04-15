package com.vidi.tutorial.pattern.create.factory.simple;

public class FactoryClient {
    public static void main(String[] args){
        Product product = Factory.getProduct("A");
        product.method();
    }
}
