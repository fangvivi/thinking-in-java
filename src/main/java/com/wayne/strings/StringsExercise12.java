package com.wayne.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;
import static com.wayne.utils.Print.printnb;

/**
 ************************** Exercise 12 ******************
 * Modify Groups.java to count all unique words
 * with no initial capital letter.
 * 找出所有不以大写字母开头的单词，不重复地计算个数
 ********************************************************
 * @author wayne
 */
public class StringsExercise12 {
    static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        // ?m 表示启用多行模式，多行模式下，^或者$会在行终止符或者输入序列的结尾之后或者之前匹配

        /*
        (?![A-Z])反向搜索，相当于匹配小写字母
        (?=[A-Z]) 正向搜索，匹配大写字母
        (?![a-z]) 反向搜索，匹配大写字母
        (?=[a-z]) 正向搜索，匹配小写字母
        */
        String answer = "\\b((?=[a-z])\\w+)\\b";
        String reg = "(?m)\\b\\p{Lower}\\w+\\b";
        String reg1 = "(?m)\\p{Lower}\\w+\\b";
        Matcher matcher = Pattern.compile(answer).matcher(POEM);
        Set<String> words = new HashSet();
        while (matcher.find()){
            for (int i = 0; i <= matcher.groupCount(); i++) {
                String group = matcher.group(i);
                words.add(group);
            }
        }
        print("the count of unique word: "+words.size());
        printnb(words);
    }
}

/*
错误输出：如果正则表达式前面不加单词边界会把大写字母开头的单词拆分
[ll, raths, mimsy, mome, gimble, that, claws, brillig, son, ubjub, gyre, abberwock, and, borogoves,
        bite, bird, id, catch, shun, toves, jaws, eware, in, outgrabe, was, my,
        the, slithy, were, nd, wabe, he, frumious, andersnatch]
        */

/*
正确输出：
[raths, mimsy, mome, gimble, that, claws, brillig, son, gyre, and, borogoves, bite, bird, catch,
        shun, toves, jaws, in, outgrabe, my, the, slithy, were, wabe, frumious]
        */


