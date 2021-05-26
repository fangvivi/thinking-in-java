package com.wayne.concurrency;

import java.util.concurrent.TimeUnit;

import static com.wayne.utils.Print.printnb;

/**
 ****************** Exercise 7 *****************
 * Experiment with different sleep times in
 * Daemons.java to see what happens.
 ***********************************************
 * @author wayne
 */
public class ConcurrencyExercise7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        printnb("t.isDaemon() = "+ t.isDaemon() +", ");
        TimeUnit.MICROSECONDS.sleep(1);
    }
}
// 在自己的电脑上就算设定为千分之一毫秒，也和样例一致，可以输出所有的内容