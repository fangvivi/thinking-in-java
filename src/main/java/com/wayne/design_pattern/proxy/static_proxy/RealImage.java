package com.wayne.design_pattern.proxy.static_proxy;

public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFile(fileName);
    }

    @Override
    public void display() {
        System.out.printf("%s%n",this.fileName);
    }

    private void loadFile(String fileName){
        System.out.printf("%s正在加载。。。%n", fileName);
    }
}
