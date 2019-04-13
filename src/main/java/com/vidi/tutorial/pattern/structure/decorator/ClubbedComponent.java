package com.vidi.tutorial.pattern.structure.decorator;

/**
 * @author vidi
 * @date 2018-08-13
 */
public class ClubbedComponent implements Component {

    private Component component;

    public ClubbedComponent(Component component) {
        this.component = component;
    }

    @Override
    public void attack() {
        component.attack();
        System.out.println("ClubbedComponent additions in attack!");
    }

    @Override
    public void fleeBattle() {
        System.out.println("ClubbedComponent additions in fleeBattle!");
        component.fleeBattle();
    }

    @Override
    public int getAttackPower() {
        return component.getAttackPower() + 2;
    }
}
