package com.wayne.jvm;

/**
 * 因为HELLOWORLD在编译期存入常量池中，所以对此常量的引用，转化为对ConstClass常量池的引用
 * 所以访问此常量不会引起类初始化
 * jdk1.8，常量池在堆中存储，类信息在源空间存储
 * @author wayne
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }
    public static final String HELLOWORLD = "hello world";
}
