package com.vidi.tutorial.concurrent.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Base operations of ExecutorService
 * @author tangleiNUAA
 */
public class BaseExecutions {
    /**
     * Stop the ExecutorService security.
     * @param executor
     */
    public static void stopExecutor(ExecutorService executor) {
        // ExecutorService must be shutdown in your code, or it would run until you kill the process.
        // Here provide a way to shutdown the ExecutorService.
        try {
            executor.shutdown();
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.out.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
