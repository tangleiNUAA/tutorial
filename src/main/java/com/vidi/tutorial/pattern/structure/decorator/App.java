package com.vidi.tutorial.pattern.structure.decorator;

/**
 * @author vidi
 * @date 2018-08-13
 */
public class App {
    public static void main(String[] args) {
        Component baseComponent = new SimpleComponent();

        Component thirdDecorator = new ThirdComponent(baseComponent);

        System.out.println("=========");
        baseComponent.attack();
        thirdDecorator.attack();

        System.out.println("=========");
        baseComponent.fleeBattle();
        thirdDecorator.fleeBattle();

        System.out.println("=========");
        System.out.println(baseComponent.getAttackPower());
        System.out.println("third: " + thirdDecorator.getAttackPower());
    }
}
