package com.wayne.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                log.debug("running");
            }
        };
        t.setName("t1");
        t.start();
        log.debug("running");
    }
}
