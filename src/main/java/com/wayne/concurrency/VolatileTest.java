package com.wayne.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 单纯使用volatile并不能保证并发安全
 * @author wayne
 */
public class VolatileTest {
    //public static volatile AtomicInteger race = new AtomicInteger(0);
    public static volatile int race = 0;

    public static void increase() {
        //race.getAndAdd(1);
        /*
        race++ 不是一个原子操作
        public static void increase();
        Code:
        0: getstatic     #2                  // Field race:I
        3: iconst_1
        4: iadd
        5: putstatic     #2                  // Field race:I
        8: return*/
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(VolatileTest::run);
            threads[i].start();
        }
        // 等待所有累加线程都结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(race);
    }

    private static void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }
}
