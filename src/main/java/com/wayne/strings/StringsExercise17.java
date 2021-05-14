package com.wayne.strings;

import com.wayne.utils.TextFile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 ********************** Exercise 17 *********************
 * Write a program that reads a Java source-code file (you
 * provide the file name on the command line) and displays
 * all the comments.
 ********************************************************
 * @author wayne
 */
public class StringsExercise17 {
    public static void main(String[] args) {
        String reg = "[?m//|/\\*.*\\*/]";
        File file = new File(args[0]);
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher("");
        int index = 0;
        for (String str : new TextFile(args[0])){
            m.reset(str);
            while (m.find()){
                print(index++ + " : " + m.group() + " : " + m.start());
            }

        }

    }


}

