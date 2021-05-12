package com.wayne.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


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
}
