package com.wayne.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author wayne
 */
public class TextFile extends ArrayList<String> {
    /**
     * Read a file as a single string:
     * @param fileName
     * @return
     */
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader in= new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()))) {
            String s;
            while((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    TextFile(String filename, String splitter){
        super(Arrays.asList(read(filename).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if(get(0).equals("")){
            remove(0);
        }
    }

    public TextFile(String filename){
        this(filename,"\n");
    }

    /**
     * 迭代获取一个目录中所有的文件，包括子目录
     * @param file 目录或文件
     * @param list 用来存放遍历到的文件
     * @return 所有遍历到的文件
     */
    public static List<File> getFiles(File file, List<File> list){
        if(!file.isDirectory()){
            list.add(file);
        } else {
            File[] files = file.listFiles();
            for (File temp : files) {
                getFiles(temp, list);
            }
        }
        return list;

    }
}
