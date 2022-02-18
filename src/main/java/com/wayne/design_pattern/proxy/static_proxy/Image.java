package com.wayne.design_pattern.proxy.static_proxy;

/**
 * 静态代理，只能为一个目标服务
 * 需要真实对象和代理对象都实现这个接口
 * 如果要为多个对象实现代理，会创建相当多的代理类
 * @author wayne
 */
public interface Image {
    /**
     * 显示图像
     */
    void display();
}
