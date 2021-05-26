package com.wayne.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wayne.utils.Print.print;

/**
 ****************** Exercise 6 *****************
 * Create a task that sleeps for a random amount
 * of time between 1 and 10 seconds, then displays
 * its sleep time and exits. Create and run a quantity
 * (given on the command line) of these tasks.
 ***********************************************
 * @author wayne
 */
public class ConcurrencyExercise6 implements Runnable{
    @Override
    public void run() {
        Random random = new Random();
        long sleepTime = random.nextInt(11);
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
            print("sleep time : " + sleepTime);
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            executorService.execute(new ConcurrencyExercise6());
        }
        executorService.shutdown();
    }
}
