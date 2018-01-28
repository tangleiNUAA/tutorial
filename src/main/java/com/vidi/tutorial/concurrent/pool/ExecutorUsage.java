package com.vidi.tutorial.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * base usage of Executor
 *
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

        // ExecutorService must be shutdown in your code, or it would run until you kill the process.
        // Here provide a way to shutdown the ExecutorService.
        try {
            System.out.println("Start the shutdown.");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
            System.out.println("Shutdown finished!");
        }
    }
}
