package com.vidi.tutorial.lambda.base;

import org.junit.Test;

public class Executor {
    private static void behave(int repeation, Operator operator) {
        for (int i = 0; i < repeation; i++) {
            operator.operate("The " + String.valueOf(i + 1) + " time operate.");
        }
    }

    @Test
    public void testLambda(){
        behave(5, System.out::println);
    }
}
