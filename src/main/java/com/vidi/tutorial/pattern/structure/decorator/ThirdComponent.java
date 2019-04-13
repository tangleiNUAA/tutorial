package com.vidi.tutorial.pattern.structure.decorator;

/**
 * @author vidi
 * @date 2018-08-13
 */
public class ThirdComponent extends ClubbedComponent {

    public ThirdComponent(Component component) {
        super(component);
    }

    @Override
    public int getAttackPower() {
        return super.getAttackPower() + 10;
    }

    @Override
    public void attack() {
        System.out.println(this.getClass().getName());
        super.attack();
    }

    @Override
    public void fleeBattle() {
        super.fleeBattle();
        System.out.println(this.getClass().getName());
    }
}
