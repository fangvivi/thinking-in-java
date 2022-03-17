package com.wayne.design_pattern.singleton;

/**
 * 线程安全的单例模式
 * @author wayne
 */
public class Singleton {
    private volatile static Singleton instance;
    public static Singleton getInstance() {
        // Double check lock
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
