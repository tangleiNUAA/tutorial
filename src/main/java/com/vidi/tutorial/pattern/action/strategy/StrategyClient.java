package com.vidi.tutorial.pattern.action.strategy;

import com.vidi.tutorial.pattern.action.strategy.concrete.ConcreteStrategyA;

public class StrategyClient {
    public static void main(String[] args){
        Context context = new Context(new ConcreteStrategyA());
        context.algorithm();
    }
}