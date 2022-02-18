package com.wayne.design_pattern.proxy.static_proxy;

public class StaticProxyDemo {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("清明上河图");
        image.display();
    }
}
