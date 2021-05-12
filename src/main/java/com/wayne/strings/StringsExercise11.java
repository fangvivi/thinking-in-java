package com.wayne.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 ************************** Exercise 11 ******************
 *Apply the regular expression
 * (?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
 * to
 * "Arline ate eight apples and one orange while Anita
 * hadn't any"
 *********************************************************
 * @author wayne
 */
public class StringsExercise11 {
    public static void main(String[] args) {
        String str = "Arline ate eight apples and one orange while Anita hadn't any";
        String reg = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        // false
        boolean matches = Pattern.matches(reg, str);
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        // find() 下次寻找可以接收一个位置参数作为搜索的开始
        while (matcher.find()){
            String group = matcher.group();
            print("Match \"" + group +"\" at position " + matcher.start() +"-" +(matcher.end()-1));

        }
        /*
        匹配到的都是以元音开始和结尾的单词
        输出：
        Match "Arline" at position 0-5
        Match " ate" at position 6-9
        Match " one" at position 27-30
        Match " orange" at position 31-37
        Match " Anita" at position 44-49
        */
    }
}
