package com.vidi.tutorial.pattern.create.singlate;

public class IoDTSingateExample {

    private IoDTSingateExample(){}

    private static class HolderClass{
        private final static IoDTSingateExample instance = new IoDTSingateExample();
    }
    public static IoDTSingateExample getInstance(){
        return HolderClass.instance;
    }

    public static void main(String[] args){
        IoDTSingateExample instance = IoDTSingateExample.getInstance();
    }

}
