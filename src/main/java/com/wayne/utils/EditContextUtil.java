package com.wayne.utils;

import java.io.*;

/**
 * 用来处理pdf的目录解构
 * @author wayne
 */
public class EditContextUtil {
    public static void main(String[] args){
        String inPath = "the source file path";
        String outPath = "the target file path";
        String temp = null;
        /*
        Using Eclipse....................... 23
        Unpacking the Distribution..................5
        Exercise 10 .........................14
        字符串中间·的部分替换为制表符
        */
        String reg = "\\s?\\.+\\s?";
        /*
        Everything is an Object  9
        最后两个空格替换为制表符
        */
        String reg1 = "\\s{2}";
        try(FileReader in = new FileReader(inPath);
            BufferedReader br = new BufferedReader(in);
            FileWriter out = new FileWriter(outPath);
            BufferedWriter bw = new BufferedWriter(out)) {
            while ((temp = br.readLine()) != null){
                System.out.println(temp);
                String s = null;
                if(temp.contains(".")){
                    s = temp.replaceAll(reg, "\t");
                } else {
                    s = temp.replaceAll(reg1,"\t");
                }
                System.out.println(s);
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
