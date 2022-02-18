package com.wayne.design_pattern.proxy.cglib_proxy;

import com.wayne.design_pattern.proxy.jdk_dynamic_proxy.IUserDao;

/**
 * @author wayne
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("数据保存");
    }
}
