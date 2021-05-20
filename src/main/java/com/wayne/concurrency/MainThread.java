package com.wayne.concurrency;

/**
 * @author wayne
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff lifeOff = new LiftOff();
        lifeOff.run();

    }
}
/*
输出：
#0(9),#0(8),#0(7),#0(6),#0(5),#0(4),#0(3),#0(2),#0(1),#0(Liftoff!),
*/
