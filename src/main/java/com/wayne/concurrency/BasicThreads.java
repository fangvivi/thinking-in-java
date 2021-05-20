package com.wayne.concurrency;

import static com.wayne.utils.Print.print;

/**
 * @author wayne
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        thread.run();
        print("等待LiftOff的run()执行……");
    }
}
    /*
    等待LiftOff的run()执行……
    #0(9),#0(8),#0(7),#0(6),#0(5),#0(4),#0(3),#0(2),#0(1),#0(Liftoff!),
    */