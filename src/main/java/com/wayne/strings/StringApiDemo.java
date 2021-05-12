package com.wayne.strings;


import java.util.Arrays;

/**
 * 一些String的API
 * @author wayne
 */
public class StringApiDemo {
    public static void main(String[] args) {
        String a = "ing";
        String b = "zhang san is eat";
        // 数组复制
        char[] dst = Arrays.copyOf(b.toCharArray(), a.length() + b.length());
        // 把一个字符串中的一些字符复制到一个指定的字符数组中
        a.getChars(0,a.length(),dst,b.length());
        //zhang san is eating
        System.out.println(new String(dst).toString());
    }
}
