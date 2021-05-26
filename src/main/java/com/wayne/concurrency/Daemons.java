package com.wayne.concurrency;

import java.util.concurrent.TimeUnit;

import static com.wayne.utils.Print.printnb;

/**
 * @author wayne
 */
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        printnb("t.isDaemon() = "+ t.isDaemon() +", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}

class Daemon implements Runnable{
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            printnb("DaemonSpawn " + i + " started, ");
        }

        for (int i = 0; i < t.length; i++) {
            printnb("t["+ i +"].isDaemon() = " + t[i].isDaemon() +", ");
        }

        while (true){
            Thread.yield();
        }
    }
}

/*
输出：
t.isDaemon() = true,
DaemonSpawn 0 started,
DaemonSpawn 1 started,
DaemonSpawn 2 started,
DaemonSpawn 3 started,
DaemonSpawn 4 started,
DaemonSpawn 5 started,
DaemonSpawn 6 started,
DaemonSpawn 7 started,
DaemonSpawn 8 started,
DaemonSpawn 9 started,
t[0].isDaemon() = true,
t[1].isDaemon() = true,
t[2].isDaemon() = true,
t[3].isDaemon() = true,
t[4].isDaemon() = true,
t[5].isDaemon() = true,
t[6].isDaemon() = true,
t[7].isDaemon() = true,
t[8].isDaemon() = true,
t[9].isDaemon() = true,
*/
