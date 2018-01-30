package com.vidi.tutorial.concurrent.pool;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * base usage of Executor
 * @author tangleiNUAA
 */
public class ExecutorUsage {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Create ExecutorService using the static method in Executors. You can chose the different type of thread pool.
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // Submit the task to executor, the executor start a thread to execute the task.
        executor.submit(task);
        executor.submit(task);

        // Use the stop util to shutdown the executor.
        BaseExecutions.stopExecutor(executor);
    }
}
