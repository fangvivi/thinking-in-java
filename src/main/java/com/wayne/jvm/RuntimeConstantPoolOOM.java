package com.wayne.jvm;

/**
 * String:intern()方法会把首次出现的字符串对象放入字符串常量池中
 * JDK1.7之后常量池在堆中
 * @author wayne
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        // 这是因为“java” 这个字符串在执行String-Builder.toString()之前就已经出现过了
        // 字符串常量池中已经有它的引用，不符合intern()方法要求“首次遇到”的原则
        // 在加载sun.misc.Version这个类的时候进入常量池的
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
