package com.vidi.tutorial.concurrent.synchronize;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * The base usage of keyword synchronized.
 * @author tangleiNUAA
 */
public class SyncInThread {
    public static int count = 0;
    public static int countSync = 0;

    void increment(){
        count ++;
    }

    synchronized void incrementSync(){
        countSync ++;
    }

    public static void main(String[] args){
        // Compare the thread without synchronized to thread with synchronized.
        ExecutorService executor = Executors.newFixedThreadPool(5);
        SyncInThread sync = new SyncInThread();
        IntStream.range(0, 10000).forEach(i -> executor.submit(sync::increment));
        BaseExecutions.stopExecutor(executor);
        System.out.println(count);

        SyncInThread sync1 = new SyncInThread();
        ExecutorService executor1 = Executors.newFixedThreadPool(5);
        IntStream.range(0, 10000).forEach(i -> executor1.submit(sync1::incrementSync));
        BaseExecutions.stopExecutor(executor1);
        System.out.println(countSync);
    }
}
