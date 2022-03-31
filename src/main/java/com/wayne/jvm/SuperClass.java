package com.wayne.jvm;

/**
 * 验证子类调用父类的静态变量，不会引起子类的初始化
 * @author wayne
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }
    public static int value = 123;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init");
    }
}
