package com.wayne.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @author wayne
 */
public class SplitDemo {
    public static void main(String[] args) {
        String str = "This!!unusual use!!of exclamation!!points";
        Pattern p = compile("!!");
        String[] split = p.split(str);
        System.out.println("no limit: " + Arrays.toString(split));
        String[] split1 = p.split(str,3);
        System.out.println("limit: " + Arrays.toString(split1));
        String[] split2 = p.split(str,-2);
        System.out.println("limit: " + Arrays.toString(split2));
    }
}

    /*
    输出：
    no limit: [This, unusual use, of exclamation, points]
       limit: [This, unusual use, of exclamation!!points]
       limit: [This, unusual use, of exclamation, points]
        */
