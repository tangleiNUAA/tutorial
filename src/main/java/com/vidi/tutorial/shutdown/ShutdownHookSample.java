package com.vidi.tutorial.shutdown;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author vidi
 * @date 2018-08-09
 */
public class ShutdownHookSample {

    private static int i = 0;
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    private static boolean shutdownSignal = false;

    public static void main(String[] args) {
        addShutdownHook();

        service.scheduleAtFixedRate(() -> {
            System.out.println(i++ + " times");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Thread sleep cause InterruptException");
            }
        }, 1L, 2L, TimeUnit.SECONDS);
    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                shutdownSignal = true;
                service.shutdown();
                System.out.println("service is " + service.isShutdown() + " shutdown");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("ShutdownHook sleep cause InterruptException");
            } finally {
                List list = service.shutdownNow();
                System.out.println("list size is: " + list.size());
            }
            System.out.println("Kill Is Trigger");

        }));
    }

}
