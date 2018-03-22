package com.vidi.tutorial.concurrent.collection.insecurity;

import com.vidi.tutorial.concurrent.util.BaseExecutions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Show why ArrayList is insecurity when using concurrent.
 * @author tangleiNUAA
 */
public class ArrayListInThread {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(100);

        // List will lost element while expand size if the adding operation does not finished.
        for (int i = 0; i < 10000; i++){
            executor.submit(() -> {
                list.add("value");
            });
        }

        // Sleep for waiting the thread finished.
        BaseExecutions.sleep(60);
        System.out.println(list.size());

        BaseExecutions.stopExecutor(executor,5);
    }
}
