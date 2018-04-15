package com.vidi.tutorial.pattern.action.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void algorithm(){
        strategy.algorithm();
    }
}
