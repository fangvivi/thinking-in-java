package com.wayne.strings;

import com.wayne.utils.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 * 在终端中直接使用java命令执行 接收参数
 * @author wayne
 */
public class JGrepCommand {
    public static void main(String[] args) {
        if(args.length < 2){
            print("需要两个参数，文件名称  正则表达式");
            System.exit(0);
        }
        Pattern pattern = Pattern.compile(args[1]);
        int index = 0;
        // 在循环外声明对象可以避免循环中重复创建
        Matcher matcher = pattern.matcher("");
        for (String str : new TextFile(args[0])){
            matcher.reset(str);
            while (matcher.find()){
                print(index++ + " : " + matcher.group() + " : " + matcher.start());
            }

        }
    }
}

