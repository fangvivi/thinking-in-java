package com.wayne.strings.exercise;

import com.wayne.utils.TextFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 ********************** Exercise 16 *********************
 * Modify JGrep.java to accept a directory name or a file
 * name as argument (if a directory is provided, search
 * should include all files in the directory).
 * Hint: you can generate a list of filenames with
 * File[] files = new File(".").listFiles();
 ********************************************************
 * @author wayne
 */
public class StringsExercise16 {
    public static void main(String[] args) {
        if(args.length < 2){
            print("需要两个参数，文件名称  正则表达式");
            System.exit(0);
        }
        File file = new File(args[0]);
        // 输入的路径可能是一个目录，这个目录中可能包含不同层级的子目录
        List<File> files = TextFile.getFiles(file, new ArrayList<File>());
        print(files);
        Pattern p = Pattern.compile(args[1]);
        Matcher m = p.matcher("");
        int index = 0;
        for(File temp : files){
            print("file name : "+temp.getName());
            for (String str : new TextFile(temp.getAbsolutePath())){
                m.reset(str);
                while (m.find()){
                    print(index++ + " : " + m.group() + " : " + m.start());
                }

            }
        }

    }


}

