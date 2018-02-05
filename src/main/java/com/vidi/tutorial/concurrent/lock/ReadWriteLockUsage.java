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
public class ReadWriteLockUsage {
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
                // If you do not liberate the lock, the read thread will never run.
                lock.writeLock().unlock();
            }
            System.out.println(Thread.currentThread().getName() + " is stop");
        });

        // read lock
        executor.submit(() -> {
            while (!lock.readLock().tryLock()) {
                System.out.println(lock.readLock().tryLock());
                BaseExecutions.sleep(1);
            }
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
