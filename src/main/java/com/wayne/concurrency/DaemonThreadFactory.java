package com.wayne.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * 使用此ThreadFactory创建的线程默认设定为后台线程
 * @author wayne
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
