package com.wayne.strings.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 ************************** Exercise 13 ******************
 * Modify StartEnd.java so that it uses Groups.POEM as
 * input, but still produces positive outputs for find(),
 * lookingAt() and matches().
 *********************************************************
 * @author wayne
 */
public class StringsExercise13 {
    public static String input = "Twas brillig, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, the claws that catch.\n" +
            "Beware the Jubjub bird, and shun\n" +
            "The frumious Bandersnatch.";

    private static class Display{
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex){
            this.regex = regex;
        }
        void display(String message){
            if(!regexPrinted){
                print("regex = " + regex);
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
        String[] regs = {"\\w*ll\\w*", "\\w*th\\w*", "B\\w+", "Th.*?\\."};
        for (String in : input.split("\n")){
            print("input: "+in);
            for (String reg : regs) {
                examine(in,reg);
            }
            
        }
    }

    /*
    输出：
    input: Twas brillig, and the slithy toves
    regex = \w*ll\w*
    find() 'brillig' start = 5 end = 12
    regex = \w*th\w*
    find() 'the' start = 18 end = 21
    find() 'slithy' start = 22 end = 28
    input: Did gyre and gimble in the wabe.
    regex = \w*th\w*
    find() 'the' start = 23 end = 26
    input: All mimsy were the borogoves,
    regex = \w*ll\w*
    find() 'All' start = 0 end = 3
    lookingAt() start = 0 end = 3
    regex = \w*th\w*
    find() 'the' start = 15 end = 18
    input: And the mome raths outgrabe.
    regex = \w*th\w*
    find() 'the' start = 4 end = 7
    find() 'raths' start = 13 end = 18
    input:
    input: Beware the Jabberwock, my son,
    regex = \w*th\w*
    find() 'the' start = 7 end = 10
    regex = B\w+
    find() 'Beware' start = 0 end = 6
    lookingAt() start = 0 end = 6
    input: The jaws that bite, the claws that catch.
    regex = \w*th\w*
    find() 'that' start = 9 end = 13
    find() 'the' start = 20 end = 23
    find() 'that' start = 30 end = 34
    regex = Th.*?\.
    find() 'The jaws that bite, the claws that catch.' start = 0 end = 41
    lookingAt() start = 0 end = 41
    matches() start = 0 end = 41
    input: Beware the Jubjub bird, and shun
    regex = \w*th\w*
    find() 'the' start = 7 end = 10
    regex = B\w+
    find() 'Beware' start = 0 end = 6
    lookingAt() start = 0 end = 6
    input: The frumious Bandersnatch.
    regex = B\w+
    find() 'Bandersnatch' start = 13 end = 25
    regex = Th.*?\. 最后一个字符必须是英文句点
    find() 'The frumious Bandersnatch.' start = 0 end = 26
    lookingAt() start = 0 end = 26
    matches() start = 0 end = 26
    */

}
