package com.vidi.tutorial.concurrent.pool;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.concurrent.*;

/**
 * Get the result form a thread while using thread pool.
 * @author tangleiNUAA
 */
public class ExecutorReturn {
    public static void main(String[] args){
        Callable<String> task = () -> Thread.currentThread().getName();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<String> future1 = executor.submit(task);
        Future<String> future2 = executor.submit(task);

        try {
            String result1 = future1.get();
            String result2 = future2.get();
            System.out.println("result1: " + result1 + "    result2:" + result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Is down? " + future1.isDone());
        System.out.println("Is down? " + future2.isDone());

        BaseExecutions.stopExecutor(executor, 5);
    }
}
