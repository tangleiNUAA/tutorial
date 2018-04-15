package com.vidi.tutorial.pattern.action.strategy.concrete;

import com.vidi.tutorial.pattern.action.strategy.Strategy;

public class ConcreteStregetyB implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("Concrete strategy B");
    }
}
