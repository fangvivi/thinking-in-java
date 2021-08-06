package com.wayne.strings.exercise;

import com.wayne.strings.Turtle;

import java.io.PrintStream;
import java.util.Formatter;

/**
 ****************** Exercise 3 ******************
 * Modify Turtle.java so that it sends all output
 * to System.err.
 * ***********************************************
 */
public class StringExercise3 {
    public static void main(String[] args) {
        PrintStream outAlias = System.err;
        Turtle zhangsan = new Turtle("ZhangSan",new Formatter(outAlias));
        Turtle lisi = new Turtle("LiSi",new Formatter(outAlias));
        zhangsan.move(1,2);
        zhangsan.move(3,2);
        lisi.move(4,9);
    }

}
/**
 * ZhangSan The Turtle is at (1,2)
 * ZhangSan The Turtle is at (3,2)
 * LiSi The Turtle is at (4,9)
 */

