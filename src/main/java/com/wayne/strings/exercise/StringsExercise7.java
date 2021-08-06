package com.wayne.strings.exercise;

/**
 ****************** Exercise 7 ******************
 * Using the documentation for java.util.regex.Pattern
 * as a resource, write and test a regular expression
 * that checks a sentence to see that it begins with a
 * capital letter and ends with a period.（大写字母开头，点结尾）
 ************************************************
 * @author wayne
 */
public class StringsExercise7 {
    public static void main(String[] args) {
        String reg = "^\\p{javaUpperCase}.*\\.$";
        String reg1 = "^[A-Z].*\\.$";
        String str = "ZZ哈哈哈哈.";
        // true
        System.out.println(str.matches(reg));
    }
}
