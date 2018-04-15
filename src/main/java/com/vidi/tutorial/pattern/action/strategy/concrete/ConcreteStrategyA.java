package com.vidi.tutorial.pattern.action.strategy.concrete;

import com.vidi.tutorial.pattern.action.strategy.Strategy;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void algorithm() {
        // Concrete strategy.
        System.out.println("Concrete strategy A");
    }
}
