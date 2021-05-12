package com.wayne.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wayne
 */
public class ReFlags {
    public static void main(String[] args) {
        String regex = "^java";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        String str = "java has regex\nJava has regex\n" +
                "JAVA has pretty good regular expressions\n" +
                "Regular expressions are in Java";
        Matcher matcher = p.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
    /*
    如果不加Pattern.MULTILINE，正则表达式默认只匹配整个字符串的开始和结尾，只会匹配到java
    输出：
    java
    Java
    JAVA
    */