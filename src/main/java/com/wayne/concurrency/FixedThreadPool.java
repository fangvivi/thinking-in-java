package com.wayne.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayne
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
