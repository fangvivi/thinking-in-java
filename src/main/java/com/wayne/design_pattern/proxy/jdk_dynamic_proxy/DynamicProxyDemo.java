package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

/**
 * 基于jdk的动态代理演示
 * 静态代理与动态代理的区别主要在：
 * 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
 * 动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，
 * 而是在运行时动态生成类字节码，并加载到JVM中
 * @author wayne
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        // 目标对象（被代理对象）
        IUserDao target = new UserDaoService();
        System.out.println(target);

        // 代理对象
        ProxyFactory proxyFactory = new ProxyFactory(target);
        IUserDao proxy = (IUserDao)proxyFactory.getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
