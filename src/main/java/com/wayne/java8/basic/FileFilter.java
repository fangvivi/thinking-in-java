package com.wayne.java8.basic;

import java.io.File;

/**
 * 筛选隐藏文件
 * @author wayne
 */
public class FileFilter {

    /**
     * 传统的方法需要把isHidden()包裹在对象里。才可以传递给listFiles()方法
     */
    public File[] getHiddenFiles(String path){
        File[] hiddenFiles = new File(path).listFiles(new java.io.FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        return hiddenFiles;
    }

    /**
     * "::" 是java8的方法引用，把方法作为值，直接传递给listFiles()方法
     */
    public File[] getHiddenFilesJava8(String path){
        return new File(path).listFiles(File::isHidden);
    }

}
