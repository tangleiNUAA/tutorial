package com.vidi.tutorial.concurrent.collection.insecurity;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Show why HashMap is insecurity when using concurrent.
 * @author tangleiNUAA
 */
public class HashMapInThread {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++){
            int finalI = i;
            executor.submit(() -> {
                map.put(String.valueOf(finalI), String.valueOf(finalI));
            });
        }

        // Sleep for waiting the thread finished.
        BaseExecutions.sleep(60);
        System.out.println(map.size());

        BaseExecutions.stopExecutor(executor, 5);
    }
}
