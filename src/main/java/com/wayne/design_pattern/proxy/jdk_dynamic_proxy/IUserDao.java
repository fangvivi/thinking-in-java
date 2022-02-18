package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

/**
 * jdk动态代理存在一个缺陷，被代理类必须实现一个或多个接口
 * @author wayne
 */
public interface IUserDao {
    void save();
}
