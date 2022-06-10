package com.wayne.io;

import java.io.*;
import java.nio.file.*;

/**
 * @author wayne
 */
public class FileDemo {

    public static void main(String[] args) {
        copy();
    }

    /**
     * 复制文件内容
     */
    public static void copy(){
        File src = new File("C:\\Users\\wayne\\Desktop\\test\\a.txt");
        // 如果文件不存在会创建
        try (InputStream in = new FileInputStream(src)){
            // 指定复制选项，可以替换已存在的文件
            Files.copy(in,
                    Paths.get("C:\\Users\\wayne\\Desktop\\test\\h.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
