package com.vidi.tutorial.concurrent.pool;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Make a block callable demo.
 * @author tangleiNUAA
 */
public class ExecutorBlockDemo {
    public static void main(String[] args){
        Callable<Integer> task = () -> {
            System.out.println(Thread.currentThread().getName() + " is start");
            Random random = new Random();
            int num = random.nextInt(30);
            for (int i = 0; i < num; i++){
                BaseExecutions.sleep(1);
            }
            return num;
        };

        ExecutorService executor = Executors.newFixedThreadPool(50);
        List<Future> results = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Future<Integer> result = executor.submit(task);
            results.add(result);
            // broke the thread using future.get()
            try {
                result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("result size is: " + results.size());

        for (Future<Integer> future:results) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        BaseExecutions.stopExecutor(executor);
    }
}
