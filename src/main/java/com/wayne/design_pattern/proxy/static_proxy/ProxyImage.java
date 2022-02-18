package com.wayne.design_pattern.proxy.static_proxy;

/**
 * Image 的 代理
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
        realImage.display();
    }
}
