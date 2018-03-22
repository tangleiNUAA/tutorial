package com.vidi.tutorial.lambda;

/**
 * Show lambda base usage to call function, the usage of "::".
 */
public class LambdaCallFunction {
    private static void function() {
        System.out.println("This function is called.");
    }

    public static void main(String[] args) {
        // Use "::" to call the static function.
        Thread thread = new Thread(LambdaCallFunction::function);
        thread.start();
    }
}
