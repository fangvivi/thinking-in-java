package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

/**
 * jdk动态代理存在一个要求，被代理类必须实现一个或多个接口
 * @author wayne
 */
public interface IUserDao {
    /**
     * 代理类和被代理类都实现了这个方法，方法名一样
     * 所以用户使用代理对象时是无感知的
     */
    void save();
}
