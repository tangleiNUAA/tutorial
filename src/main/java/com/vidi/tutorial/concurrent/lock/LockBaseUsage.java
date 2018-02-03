package com.vidi.tutorial.concurrent.lock;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Base usage of lock.
 * Use the ReentrantLock.
 * @author tangleiNUAA
 */
public class LockBaseUsage {

    public static final int NUM_INCREMENT = 10000;

    public static ReentrantLock lock = new ReentrantLock();

    public static int count = 0;

    public static void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void testLock() {
        count = 0;
        ExecutorService executor = Executors.newFixedThreadPool(5);

        IntStream.range(0, NUM_INCREMENT).forEach(i -> executor.submit(LockBaseUsage::increment));

        BaseExecutions.stopExecutor(executor, 10);
        System.out.println(count);
    }

    public static void main(String[] args) {
        testLock();
    }
}
