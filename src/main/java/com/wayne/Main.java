package com.wayne;

public class Main {
    public static void main(String[] args) {
        String str = "元 9";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String s = Integer.toHexString(chars[i]);
            System.out.println(s);
        }
    }
}
