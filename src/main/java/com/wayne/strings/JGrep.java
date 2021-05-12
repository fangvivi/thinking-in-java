package com.wayne.strings;

import com.wayne.utils.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 * @author wayne
 */
public class JGrep {
    public static void main(String[] args) {
        String filename = "src/main/java/com/wayne/strings/JGrep.java";
        String reg = "\\b[Ssct]\\w+";
        Pattern pattern = Pattern.compile(reg);
        int index = 0;
        // 在循环外声明对象可以避免循环中重复创建
        Matcher matcher = pattern.matcher("");
        for (String str : new TextFile(filename)){
            matcher.reset(str);
            while (matcher.find()){
                print(index++ + " : " + matcher.group() + " : " + matcher.start());
            }

        }
    }
}

