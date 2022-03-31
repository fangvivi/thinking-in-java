package com.wayne.jvm;

/**
 * 子类调用父类的静态变量不会引起子类的初始化
 * 但是会引起子类的加载
 * @author wayne
 */
public class NotInitialization {
    public static void main(String[] args) {
        // 不会引起子类的初始化
        System.out.println(SubClass.value);
        // 不会引起父类的初始化
        SuperClass[] sca = new SuperClass[10];
        // 不会引起ConstClass的初始化
        System.out.println(ConstClass.HELLOWORLD);
        Class cls = SubClass.class;

    }
}
/*
 * output:
 * SuperClass init
 * 123
 * ----------
 * 没有输出
 * ----------
 * hello world
 */