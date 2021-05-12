package com.wayne.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * ************************** Exercise 14 ******************
 * * Rewrite SplitDemo using String.split().
 * *********************************************************
 * @author wayne
 */
public class StringsExercise14 {
    public static void main(String[] args) {
        String str = "This!!unusual use!!of exclamation!!points";
        String reg = "!!";
        String[] split = str.split(reg);
        System.out.println("no limit: " + Arrays.toString(split));
        split = str.split(reg,5);
        System.out.println("limit: " + Arrays.toString(split));
        split = str.split(reg,-5);
        System.out.println("limit: " + Arrays.toString(split));
    }
}

    /*
    输出：
    no limit: [This, unusual use, of exclamation, points]
        limit: [This, unusual use, of exclamation, points]
        limit: [This, unusual use, of exclamation, points]
        */
