package com.vidi.tutorial.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Base usage of callable and future to get result of a thread.
 *
 * @author tangleiNUAA
 */
public class ResultInThread {
    public static void main(String[] args) {
        Callable<String> task = () -> Thread.currentThread().getName();

        // Using FutureTask to make the task can be executed by thread.
        FutureTask<String> future = new FutureTask<>(task);

        new Thread(future).start();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
