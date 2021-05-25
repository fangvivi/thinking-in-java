package com.wayne.concurrency;

import java.util.concurrent.TimeUnit;

import static com.wayne.utils.Print.print;

/**
 * @author wayne
 */
public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " : " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
                print("sleep() interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
