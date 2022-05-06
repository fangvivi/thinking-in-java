package com.wayne.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 */
@Slf4j
public class ThreadStatusTest {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    /**
     * NEW RUNNABLE
     */
    public static void test1(){
        Thread t1 = new Thread(()->{
            log.debug("running。。。");
        }, "t1");
        // 线程被创建出来，在调用start()方法之前，状态为 NEW
        log.debug(t1.getState().toString());
        t1.start();
        // 调用start()之后，状态变为 RUNNABLE
        log.debug(t1.getState().toString());

        /*
        11:14:43.138 [main] DEBUG com.wayne.concurrency.ThreadStatusTest - NEW
        11:14:43.141 [main] DEBUG com.wayne.concurrency.ThreadStatusTest - RUNNABLE
        11:14:43.141 [t1] DEBUG com.wayne.concurrency.ThreadStatusTest - running。。。
         */
    }

    /**
     * RUNNABLE TIMED_WAITING
     */
    public static void test2(){
        Thread t1 = new Thread(()->{
            try {
                //Thread.sleep(2000);
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();
        log.debug("t1 status {}",t1.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1 status {}",t1.getState());

        /*
        16:09:07.764 [main] DEBUG com.wayne.concurrency.ThreadStatusTest - t1 status RUNNABLE
        16:09:08.269 [main] DEBUG com.wayne.concurrency.ThreadStatusTest - t1 status TIMED_WAITING
        */

    }

    /**
     * 打断 TIMED_WAITING
     * @throws InterruptedException
     */
    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("enter slepp...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.debug("wake up...");
                e.printStackTrace();
            }
        }, "t1");

        t1.start();
        Thread.sleep(1000);
        log.debug("interrupting...");
        t1.interrupt();

        /*
        16:15:30.402 [t1] DEBUG com.wayne.concurrency.ThreadStatusTest - enter slepp...
        16:15:31.404 [main] DEBUG com.wayne.concurrency.ThreadStatusTest - interrupting...
        16:15:31.404 [t1] DEBUG com.wayne.concurrency.ThreadStatusTest - wake up...
        java.lang.InterruptedException: sleep interrupted
            at java.lang.Thread.sleep(Native Method)
            at com.wayne.concurrency.ThreadStatusTest.lambda$test3$2(ThreadStatusTest.java:70)
            at java.lang.Thread.run(Thread.java:745)
         */
    }


}
