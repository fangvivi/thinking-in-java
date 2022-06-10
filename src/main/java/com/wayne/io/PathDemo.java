package com.wayne.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * Path可以用于在文件系统中定位文件
 * @author wayne
 */
public class PathDemo {
    public static void main(String[] args) {
        //whiteToFile();
        pathToFile();
    }

    /**
     * 创建一个文件，然后往这个文件中写入数据
     */
    public static void whiteToFile(){
        // 指定要创建文件的路径
        Path logFile = Paths.get("C:\\Users\\wayne\\Desktop\\test\\a.txt");
        // 默认操作是 CREATE, TRUNCATE_EXISTING, and WRITE
        // 没有的话，先创建文件；文件存在的话先清除文件中的内容，然后再写入新的内容
        try (BufferedWriter writer =
                     Files.newBufferedWriter(logFile, StandardCharsets.UTF_8)) {
            writer.write("百日依山尽");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在指定的路径创建文件
     */
    public static void pathToFile() {
        Path path = Paths.get("C:\\Users\\wayne\\Desktop\\test\\a");
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
