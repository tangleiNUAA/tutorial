package com.vidi.tutorial.pattern.create.singlate;

public class EagerSingateExample {
    private static EagerSingateExample instance = new EagerSingateExample();
    public EagerSingateExample(){}

    public static EagerSingateExample getInstance(){
        return instance;
    }

    public static void main(String[] args){
        EagerSingateExample instance = EagerSingateExample.getInstance();
        EagerSingateExample instance1 = EagerSingateExample.getInstance();
    }
}
