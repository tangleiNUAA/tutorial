package com.vidi.tutorial.concurrent.lock;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Show the lock status of thread.
 * @author tangleiNUAA
 */
public class ShowLockCourse {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ReentrantLock lock = new ReentrantLock();

        executor.submit(() -> {
            lock.lock();
            try {
                BaseExecutions.sleep(10);
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("lock status: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean isLocked = lock.tryLock();
            System.out.println(Thread.currentThread().getName() + " lock status is: " + isLocked);
        });

        BaseExecutions.sleep(10);
        executor.submit(() -> {
            System.out.println("lock status: " + lock.isLocked());
            System.out.println("Held by me" + lock.isHeldByCurrentThread());
            boolean isLocked = lock.tryLock();
            System.out.println(Thread.currentThread().getName() + " lock status is: " + isLocked);
        });

        BaseExecutions.stopExecutor(executor, 20);
    }
}
