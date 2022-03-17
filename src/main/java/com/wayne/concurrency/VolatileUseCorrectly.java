package com.wayne.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用volatile的场景
 * @author wayne
 */
@Slf4j
public class VolatileUseCorrectly {
    volatile boolean shutdownRequested;
    public void shutdown() {
        shutdownRequested = true;
        log.info("stop working");
    }
    public void doWork() {
        while (!shutdownRequested) {
            log.info("【{}】 is working...",Thread.currentThread().getName());
            // 代码的业务逻辑
        }
    }

    public static void main(String[] args) {
        VolatileUseCorrectly use = new VolatileUseCorrectly();
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(()->{use.doWork();});
            t.start();
        }
        try {
            Thread.sleep(5000);
            use.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
