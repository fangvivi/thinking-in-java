package com.wayne.concurrency;

/**
 * @author wayne
 */
public class Daemons {
}
class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}

