package com.wayne.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayne
 */
public class SimplePriorities implements Runnable{
    private int countDown = 5;
    // No optimization
    private volatile double d;
    private int priority;
    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
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
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
        /*
        优先级最高的线程，先执行的比例接近80%
        输出：
        Thread[pool-1-thread-2,1,main]: 5
        Thread[pool-1-thread-3,1,main]: 5
        Thread[pool-1-thread-1,1,main]: 5
        Thread[pool-1-thread-6,10,main]: 5
        Thread[pool-1-thread-5,1,main]: 5
        Thread[pool-1-thread-4,1,main]: 5
        Thread[pool-1-thread-3,1,main]: 4
        Thread[pool-1-thread-6,10,main]: 4
        Thread[pool-1-thread-2,1,main]: 4
        Thread[pool-1-thread-5,1,main]: 4
        Thread[pool-1-thread-6,10,main]: 3
        Thread[pool-1-thread-3,1,main]: 3
        Thread[pool-1-thread-2,1,main]: 3
        Thread[pool-1-thread-1,1,main]: 4
        Thread[pool-1-thread-4,1,main]: 4
        Thread[pool-1-thread-5,1,main]: 3
        Thread[pool-1-thread-6,10,main]: 2
        Thread[pool-1-thread-3,1,main]: 2
        Thread[pool-1-thread-2,1,main]: 2
        Thread[pool-1-thread-4,1,main]: 3
        Thread[pool-1-thread-1,1,main]: 3
        Thread[pool-1-thread-5,1,main]: 2
        Thread[pool-1-thread-6,10,main]: 1
        Thread[pool-1-thread-3,1,main]: 1
        Thread[pool-1-thread-1,1,main]: 2
        Thread[pool-1-thread-2,1,main]: 1
        Thread[pool-1-thread-4,1,main]: 2
        Thread[pool-1-thread-5,1,main]: 1
        Thread[pool-1-thread-1,1,main]: 1
        Thread[pool-1-thread-4,1,main]: 1
        */