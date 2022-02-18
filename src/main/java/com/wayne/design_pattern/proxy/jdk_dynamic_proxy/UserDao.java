package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

/**
 * @author wayne
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("数据保存");
    }
}
