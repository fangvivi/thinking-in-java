package com.wayne.strings;

import java.util.Arrays;

/**
 * String的split()使用
 * @author wayne
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void split(String regex){
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        // 按照空格拆分
        split(" ");
        // \W 表示非单词字符 [a-zA-Z0-9]，相当于去掉所有的符号和空格
        split("\\W+");
        split("n\\W+");

    }
}
