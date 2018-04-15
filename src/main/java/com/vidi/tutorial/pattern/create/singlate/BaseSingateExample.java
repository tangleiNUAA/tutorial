package com.vidi.tutorial.pattern.create.singlate;

public class BaseSingateExample {
    private static BaseSingateExample instance = null;

    private BaseSingateExample() {
        System.out.println("Create instance of BaseSingateExamole.");
    }

    public static BaseSingateExample getInstance() {
        if (instance == null) {
            instance = new BaseSingateExample();
        }
        return instance;
    }

    public static void main(String[] args){
        BaseSingateExample instance = BaseSingateExample.getInstance();
        BaseSingateExample instance2 = BaseSingateExample.getInstance();
    }
}
