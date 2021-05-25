package com.wayne.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.wayne.utils.Print.print;
import static com.wayne.utils.Print.printnb;

/**
 ****************** Exercise 3 *****************
 * Repeat Exercise 1 using the different types of
 * executors shown in this section.
 **********************************************
 * @author wayne
 */
public class ConcurrencyExercise3 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        print("CachedThreadPool start");
        for (int i = 0; i < 5; i++) {
            exec.execute(new Printer());
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newFixedThreadPool(3);
        print("FixedThreadPool start");
        for (int i = 0; i < 5; i++) {
            exec.execute(new Printer());
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newSingleThreadExecutor();
        print("SingleThreadExecutor start");
        for (int i = 0; i < 5; i++) {
            exec.execute(new Printer());
        }
        Thread.yield();
        exec.shutdown();
    }
}

/**
输出：
第1遍，ID：0
第1遍，ID：2
第2遍，ID：0
第1遍，ID：3
第1遍，ID：1
第3遍，ID：0
第2遍，ID：2
输出结束，ID：0
第3遍，ID：2
输出结束，ID：2
第2遍，ID：3
第2遍，ID：1
第3遍，ID：3
第3遍，ID：1
输出结束，ID：3
输出结束，ID：1
        */
