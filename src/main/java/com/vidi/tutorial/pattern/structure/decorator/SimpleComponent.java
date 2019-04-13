package com.vidi.tutorial.pattern.structure.decorator;

/**
 * @author vidi
 * @date 2018-08-13
 */
public class SimpleComponent implements Component {

    @Override
    public void attack() {
        System.out.println("SimpleComponent attack");
    }

    @Override
    public void fleeBattle() {
        System.out.println("SimpleComponent fleeBattle");
    }

    @Override
    public int getAttackPower() {
        return 1;
    }
}
