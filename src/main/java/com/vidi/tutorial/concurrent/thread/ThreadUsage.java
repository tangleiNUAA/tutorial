package com.vidi.tutorial.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * Base usage of thread.
 * @author tangleiNUAA
 */
public class ThreadUsage {
    public static void main(String[] args) {
        // define what the thread execute
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task);

        thread.start();
        System.out.println("end");
    }
}
