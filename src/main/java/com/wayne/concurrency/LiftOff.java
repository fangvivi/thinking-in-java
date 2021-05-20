package com.wayne.concurrency;


import static com.wayne.utils.Print.printnb;

/**
 * @author wayne
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "),";
    }
    @Override
    public void run() {
        while (countDown-- > 0){
            printnb(status());
            Thread.yield();
        }
    }
}
