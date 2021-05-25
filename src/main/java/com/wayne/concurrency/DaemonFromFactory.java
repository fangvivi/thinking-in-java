package com.wayne.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wayne.utils.Print.print;

/**
 * @author wayne
 */
public class DaemonFromFactory implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " : " + this);
            } catch (InterruptedException e) {
                print("Interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        print("All daemons started");
        // Run for a while
        TimeUnit.MILLISECONDS.sleep(300);
        print("main id end");
    }
}
/*
输出：
修改main方法的sleep参数，可以控制run方法的输出次数
All daemons started
Thread[Thread-0,5,main] : com.wayne.concurrency.DaemonFromFactory@d7d3bd8
Thread[Thread-3,5,main] : com.wayne.concurrency.DaemonFromFactory@5c10554d
Thread[Thread-4,5,main] : com.wayne.concurrency.DaemonFromFactory@5d17058b
Thread[Thread-5,5,main] : com.wayne.concurrency.DaemonFromFactory@568272d4
Thread[Thread-2,5,main] : com.wayne.concurrency.DaemonFromFactory@1f9cf9fd
Thread[Thread-1,5,main] : com.wayne.concurrency.DaemonFromFactory@63cfbab1
Thread[Thread-9,5,main] : com.wayne.concurrency.DaemonFromFactory@783493e5
Thread[Thread-8,5,main] : com.wayne.concurrency.DaemonFromFactory@7c73c20c
Thread[Thread-6,5,main] : com.wayne.concurrency.DaemonFromFactory@3c2762d4
Thread[Thread-7,5,main] : com.wayne.concurrency.DaemonFromFactory@1b7e87af
Thread[Thread-5,5,main] : com.wayne.concurrency.DaemonFromFactory@568272d4
Thread[Thread-1,5,main] : com.wayne.concurrency.DaemonFromFactory@63cfbab1
Thread[Thread-2,5,main] : com.wayne.concurrency.DaemonFromFactory@1f9cf9fd
Thread[Thread-3,5,main] : com.wayne.concurrency.DaemonFromFactory@5c10554d
Thread[Thread-4,5,main] : com.wayne.concurrency.DaemonFromFactory@5d17058b
Thread[Thread-0,5,main] : com.wayne.concurrency.DaemonFromFactory@d7d3bd8
Thread[Thread-9,5,main] : com.wayne.concurrency.DaemonFromFactory@783493e5
Thread[Thread-7,5,main] : com.wayne.concurrency.DaemonFromFactory@1b7e87af
Thread[Thread-8,5,main] : com.wayne.concurrency.DaemonFromFactory@7c73c20c
Thread[Thread-6,5,main] : com.wayne.concurrency.DaemonFromFactory@3c2762d4
Thread[Thread-5,5,main] : com.wayne.concurrency.DaemonFromFactory@568272d4
Thread[Thread-2,5,main] : com.wayne.concurrency.DaemonFromFactory@1f9cf9fd
Thread[Thread-0,5,main] : com.wayne.concurrency.DaemonFromFactory@d7d3bd8
Thread[Thread-4,5,main] : com.wayne.concurrency.DaemonFromFactory@5d17058b
Thread[Thread-3,5,main] : com.wayne.concurrency.DaemonFromFactory@5c10554d
Thread[Thread-1,5,main] : com.wayne.concurrency.DaemonFromFactory@63cfbab1
Thread[Thread-9,5,main] : com.wayne.concurrency.DaemonFromFactory@783493e5
Thread[Thread-8,5,main] : com.wayne.concurrency.DaemonFromFactory@7c73c20c
Thread[Thread-7,5,main] : com.wayne.concurrency.DaemonFromFactory@1b7e87af
Thread[Thread-6,5,main] : com.wayne.concurrency.DaemonFromFactory@3c2762d4
Thread[Thread-4,5,main] : com.wayne.concurrency.DaemonFromFactory@5d17058b
Thread[Thread-0,5,main] : com.wayne.concurrency.DaemonFromFactory@d7d3bd8
Thread[Thread-3,5,main] : com.wayne.concurrency.DaemonFromFactory@5c10554d
Thread[Thread-1,5,main] : com.wayne.concurrency.DaemonFromFactory@63cfbab1
Thread[Thread-2,5,main] : com.wayne.concurrency.DaemonFromFactory@1f9cf9fd
Thread[Thread-5,5,main] : com.wayne.concurrency.DaemonFromFactory@568272d4
Thread[Thread-7,5,main] : com.wayne.concurrency.DaemonFromFactory@1b7e87af
Thread[Thread-8,5,main] : com.wayne.concurrency.DaemonFromFactory@7c73c20c
Thread[Thread-6,5,main] : com.wayne.concurrency.DaemonFromFactory@3c2762d4
Thread[Thread-9,5,main] : com.wayne.concurrency.DaemonFromFactory@783493e5
main id end
*/
