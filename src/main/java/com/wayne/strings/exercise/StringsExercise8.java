package com.wayne.strings.exercise;

import com.wayne.strings.Splitting;

import java.util.Arrays;

/**
 * ****************** Exercise 8 ******************
 *  Split the string Splitting.knights on the words
 *  "the" or "you."
 * ************************************************
 * @author wayne
 */
public class StringsExercise8 {
    public static void main(String[] args) {
        String reg = "the|boy";
        String[] split = Splitting.knights.split(reg);
        System.out.println(Arrays.toString(split));
        /*
        输出：
        [Then, when , have found , shrubbery, , must cut down ,
                mightiest tree in , forest... with... a herring!]*/
    }
}
