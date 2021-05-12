package com.wayne.strings;

/**
 * 1、括号表示分组
 * 2、| 表示或者
 * @author wayne
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+999".matches("-?\\d+"));
        System.out.println("+999".matches("(-|\\+)?\\d+"));

        /*
        输出：
        true
        true
        false
        true
        */
    }
}
