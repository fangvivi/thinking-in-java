package com.wayne.concurrency;

/**
 ****************** Exercise 8 *****************
 * Modify MoreBasicThreads.java so that all the
 * threads are daemon threads, and verify that the
 * program ends as soon as main() is able to exit.
 ***********************************************
 * @author wayne
 */
public class ConcurrencyExercise8 extends Thread{
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("等待LiftOff的run()执行……");
    }
}

/*
输出：
#1(9),#2(9),等待LiftOff的run()执行……
#0(9),#2(8),#1(8),#0(8),#2(7),#3(9),#2(6),#4(9),#3(8),#2(5),#1(7),#0(7),#1(6),#2(4),#3(7),#4(8),#3(6),#2(3),#1(5),#0(6),
*/
