package com.wayne.concurrency;

/**
 ****************** Exercise 1 *****************
 * Implement a Runnable. Inside run(), print a
 * message, and then call yield(). Repeat this
 * three times, and then return from run(). Put
 * a startup message in the constructor and a
 * shutdown message when the task terminates. Create
 * a number of these tasks and drive them using
 * threads.
 ***********************************************
 * @author wayne
 */
public class concurrencyExercise1{
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new Printer()).start();
        }
    }
}

class Printer implements Runnable{
    private static int taskCount;
    private final int id = taskCount++;
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("第" + (i+1) +"遍，ID：" + id);
            // Thread.yield();
        }
        System.out.println("输出结束，ID：" + id);
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
