package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

/**
 * 被代理的类
 * @author wayne
 */
public class UserDaoService implements IUserDao{
    /**
     * 代理对象会增强这个方法
     */
    @Override
    public void save() {
        System.out.println("数据保存");
    }
}
