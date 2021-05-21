package com.wayne.concurrency;

/**
 * @author wayne
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("等待LiftOff的run()执行……");
    }
}
    /*
    输出：
    等待LiftOff的run()执行……
      #1(9),#3(9),#0(9),#1(8),#3(8),#1(7),#3(7),#1(6),#0(8),#3(6),#1(5),
      #0(7),#1(4),#0(6),#3(5),#1(3),#0(5),#3(4),#1(2),#0(4),#3(3),#1(1),
      #0(3),#3(2),#1(Liftoff!),#0(2),#3(1),#0(1),#3(Liftoff!),#0(Liftoff!),
      #2(9),#4(9),#2(8),#4(8),#2(7),#4(7),#2(6),#4(6),#2(5),#4(5),#2(4),
      #4(4),#2(3),#4(3),#2(2),#4(2),#2(1),#4(1),#2(Liftoff!),#4(Liftoff!),
        */