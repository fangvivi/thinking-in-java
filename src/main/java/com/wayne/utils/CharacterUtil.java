package com.wayne.utils;

/**
 * @author wayne
 */
public class CharacterUtil {

    public static void main(String[] args) {
        printUnicode("a");
    }

    /**
     * 打印指定字符串中字符的unicode编码
     * @param str
     */
    public static void printUnicode(String str){
        System.out.println("下面是["+str+"]中所有字符的unicode编码");
        char[] chars = str.toCharArray();
        for (char c : chars) {
            String hexStr = Integer.toHexString(c);
            // 获取16进制编码的长度
            int length = hexStr.length();
            // 长度不够4位在前面补0
            StringBuilder stringBuilder = new StringBuilder("");
            if(length < 4){
                for (int i = 0; i < 4-length; i++) {
                    stringBuilder.append("0");
                }
                hexStr = stringBuilder.append(hexStr).toString();
            }
            System.out.printf("[%s]的unicode编码是[\\u%4s]\n",c,hexStr);
            // System.out.println("【"+c+"】的unicode编码是【\\u"+hexStr+"】");
        }
    }
}
