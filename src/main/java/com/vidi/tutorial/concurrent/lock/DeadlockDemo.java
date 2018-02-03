package com.vidi.tutorial.concurrent.lock;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Try get a deadlock thread example.
 * This process will run forever until you kill the process or stop running in your IDE(like IntelliJ).
 * @author tangleiNUAA
 */
public class DeadlockDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Map<String, String> map = new HashMap<>(1);
        ReadWriteLock lock = new ReentrantReadWriteLock();

        // write lock
        executor.submit(() -> {
            lock.writeLock().lock();
            try {
                BaseExecutions.sleep(3);
                map.put("key", "value");
            } finally {
                lock.writeLock().unlock();
            }
            System.out.println(Thread.currentThread().getName() + " is stop");
        });

        // try write when the last thread is lock.
        executor.submit(() -> {
            lock.writeLock().lock();
            try {
                BaseExecutions.sleep(3);
                map.put("key2", "value2");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is stop");
        });

        // read lock
        executor.submit(() -> {
            // Next line code will enter a deadlock.
            lock.readLock().lock();
            try {
                BaseExecutions.sleep(1);
                System.out.println(map.get("key"));
            } finally {
                lock.readLock().unlock();
            }
            System.out.println(Thread.currentThread().getName() + "is stop");
        });

        BaseExecutions.stopExecutor(executor, 20);
    }
}
