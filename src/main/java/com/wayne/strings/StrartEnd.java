package com.wayne.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 * @author wayne
 */
public class StrartEnd {
    public static String input =
            "As long as there is injustice, whenever a\n" +
                    "Targathian baby cries out, wherever a distress\n" +
                    "signal sounds among the stars ... We'll be there.\n" +
                    "This fine ship, and this fine crew ...\n" +
                    "Never give up! Never surrender!";

    private static class Display{
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex){
            this.regex = regex;
        }
        void display(String message){
            if(!regexPrinted){
                print("regex '" + regex +"'");
                regexPrinted = true;
            }
            print(message);
        }
    }

    static void examine(String s, String reg){
        Display display = new Display(reg);
        Matcher matcher = Pattern.compile(reg).matcher(s);
        while (matcher.find()) {
            display.display("find() '" + matcher.group() +"' " +
                    "start = " +matcher.start() + " end = " + (matcher.end()));
        }
        // lookingAt()从字符串的第一个字符开始匹配，部分匹配上就算匹配成功
        if(matcher.lookingAt()){
            display.display("lookingAt() start = " + matcher.start() + " end = " + matcher.end());
        }
        // matches()从字符串第一个字符开始匹配，整个字符串全部匹配才算匹配成功
        if(matcher.matches()){
            display.display("matches() start = "+ matcher.start() + " end = " + matcher.end());
        }
    }

    public static void main(String[] args) {
        String[] regs = {"\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!"};
        for (String in : input.split("\n")){
            print("input: "+in);
            for (String reg : regs) {
                examine(in,reg);
            }
            
        }
    }

}

        /*
        输出：
        input: As long as there is injustice, whenever a
        regex '\w*ere\w*'
        find() 'there' start = 11 end = 16
        regex '\w*ever'
        find() 'whenever' start = 31 end = 39
        input: Targathian baby cries out, wherever a distress
        regex '\w*ere\w*'
        find() 'wherever' start = 27 end = 35
        regex '\w*ever'
        find() 'wherever' start = 27 end = 35
        regex 'T\w+'
        find() 'Targathian' start = 0 end = 10
        lookingAt() start = 0 end = 10
        input: signal sounds among the stars ... We'll be there.
        regex '\w*ere\w*'
        find() 'there' start = 43 end = 48
        input: This fine ship, and this fine crew ...
        regex 'T\w+'
        find() 'This' start = 0 end = 4
        lookingAt() start = 0 end = 4
        input: Never give up! Never surrender!
        regex '\w*ever'
        find() 'Never' start = 0 end = 5
        find() 'Never' start = 15 end = 20
        lookingAt() start = 0 end = 5
        regex 'Never.*?!'
        find() 'Never give up!' start = 0 end = 14
        find() 'Never surrender!' start = 15 end = 31
        lookingAt() start = 0 end = 14  lookingAt() 匹配的是开始部分
        matches() start = 0 end = 31  matches()匹配的是整个字符串
        */
