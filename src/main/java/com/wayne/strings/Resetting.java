package com.wayne.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;
import static com.wayne.utils.Print.printnb;

/**
 * @author wayne
 */
public class Resetting {
    public static void main(String[] args) {
        String str = "fix the bug with bags";
        Matcher matcher = Pattern.compile("[frb][aiu][gx]").matcher(str);
        while (matcher.find()){
            printnb(matcher.group() + " ");
        }
        print();
        matcher.reset("fix the bags with bug");
        while (matcher.find()){
            printnb(matcher.group() + " ");
        }
    }
}
        /*
        输出：
        fix bug bag
        fix bag bug
        */