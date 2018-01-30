package com.vidi.tutorial.concurrent.pool;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * The base usage of Schedule executor.
 * @author tangleiNUAA
 */
public class ScheduleExecutorUsage {
    public static void main(String[] args){
        Runnable task = () -> {
            System.out.println("Schedule: " + System.nanoTime());
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // get the return future object
        // scheduleAtFixedRate() run the schedule with a fixed rate
        // scheduleWithFixDelay() init the time the first task should wait
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(1377);
            // get the delay of this thread
            long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
            System.out.printf("Remaining delay: %sms", remainingDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BaseExecutions.stopExecutor(executor);
    }
}
