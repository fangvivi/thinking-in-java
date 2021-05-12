package com.wayne.utils;

import java.io.PrintStream;

/**
 * @author wayne
 */
public class Print {


    /**
     * Print with a newline
     * @param obj
     */
    public static void print(Object obj) {
        System.out.println(obj);
    }

    /**
     * Print a newline by itself
     */
    public static void print() {
        System.out.println();
    }

    /**
     * Print with no line break:
     * @param obj
     */
    public static void printnb(Object obj) {
        System.out.print(obj);
    }

    /**
     * The new Java SE5 printf() (from C)
     * @param format
     * @param args
     * @return
     */
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}