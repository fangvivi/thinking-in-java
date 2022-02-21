package com.wayne.design_pattern.proxy.static_proxy;

/**
 * Image的代理
 * @author wayne
 */
public class ProxyImage implements Image{
    private Image realImage;
    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        // 在调用真实对象的方法前后，可以加一些其他的逻辑，丰富原对象的方法
        realImage.display();
    }
}
