package com.vidi.tutorial.pattern.create.singlate;

public class LazySingateExample {
    public static LazySingateExample instance = null;
    private LazySingateExample(){}

    public static LazySingateExample getInstance(){
        if (instance == null){
            synchronized (LazySingateExample.class){
                instance = new LazySingateExample();
            }
        }
        return instance;
    }

    public static void main(String[] args){
        LazySingateExample instance = LazySingateExample.getInstance();
        LazySingateExample instance1 = LazySingateExample.getInstance();
    }
}
