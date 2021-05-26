package com.wayne.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 ****************** Exercise 9 *****************
 * Modify SimplePriorities.java so that a custom
 * ThreadFactory sets the priorities of the threads.
 ***********************************************
 * @author wayne
 */
public class ConcurrencyExercise9 implements Runnable{
    private int countDown = 5;
    // No optimization
    private volatile double d;
    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }


    @Override
    public void run() {
        while (true){
            // 如果注释掉这些浮点运算，由于运行时间过短，线程的优先级会失去效果
            for (int i = 1; i < 10000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if(i % 1000 == 0){
                    // 提示线程调度器把时间片分给优先级相同的线程，只是一个提示，不保证一定有效
                    Thread.yield();
                }
            }
            // 此处输出toString()的返回值
            System.out.println(this);

            if(--countDown == 0){
                return;
            }
        }
    }



    public static void main(String[] args) {
        ExecutorService executorService = Executors.
                newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ConcurrencyExercise9());
        }
        executorService.execute(new ConcurrencyExercise9());
        executorService.shutdown();
    }
}

class PriorityThreadFactory implements ThreadFactory{
    private final int priority;
    public PriorityThreadFactory(int priority){
        this.priority = priority;
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(priority);
        return thread;
    }
}