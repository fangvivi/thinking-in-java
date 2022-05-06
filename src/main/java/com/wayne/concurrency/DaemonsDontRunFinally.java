package com.wayne.concurrency;

import java.util.concurrent.TimeUnit;

import static com.wayne.utils.Print.print;

/**
 * @author wayne
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
         t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable{

    @Override
    public void run() {
        try {
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        } finally {
            print("This should always run?");
        }
    }
}

    /*
    输出：
    后台线程不会执行finally
    Starting ADaemon
    This should always run?
    */