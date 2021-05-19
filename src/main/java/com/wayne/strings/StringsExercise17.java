package com.wayne.strings;

import com.wayne.utils.TextFile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 ********************** Exercise 17 *********************
 * Write a program that reads a Java source-code file (you
 * provide the file name on the command line) and displays
 * all the comments.
 ********************************************************
 * @author wayne
 */
public class StringsExercise17 {
    /**
     * (?x) Comments 注释中的空格和正则表达式中#到行尾的内容会被忽略
     * (?m) Multiline 匹配 行尾结束符或者输入字符串的中 ^ 之后的部分；行尾结束符或者输入字符串的中 $ 之前的部分
     * (?s) Dotall 匹配所有的字符，包括行尾结束符
     * */
    static final  String reg = "(?x)(?m)(?s)/\\*(.*?)\\*/|//(.*?)$";
    public static void main(String[] args) {
        File file = new File(args[0]);
        Pattern p = Pattern.compile(reg);
        String read = TextFile.read(args[0]);
        Matcher m = p.matcher(read);
        while (m.find()){
            System.out.println("groupCount : " + m.groupCount());
            System.out.println(m.group(1) != null ? m.group(1) : m.group(0));
        }
    }
}

/*
会输出正则表达式的一部分内容
输出：
groupCount : 2
        *
        ********************** Exercise 17 *********************
        * Write a program that reads a Java source-code file (you
        * provide the file name on the command line) and displays
        * all the comments.
        ********************************************************
        * @author wayne

        groupCount : 2
        *
        * (?x) Comments 注释中的空格和正则表达式中#到行尾的内容会被忽略
        * (?m) Multiline 匹配 行尾结束符或者输入字符串的中 ^ 之后的部分；行尾结束符或者输入字符串的中 $ 之前的部分
        * (?s) Dotall 匹配所有的字符，包括行尾结束符
        *
        groupCount : 2
//(.*?)$";*/

