package com.wayne.design_pattern.proxy.cglib_proxy;

/**
 * cglib与动态代理最大的区别就是
 * 使用动态代理的对象必须实现一个或多个接口
 * 使用cglib代理的对象则无需实现接口，达到代理类无侵入。
 *
 * @author wayne
 */
public class CGLibProxyDemo {
    public static void main(String[] args) {
        // 目标对象
        UserDao dao = new UserDao();
        System.out.println(dao);
        // 代理对象
        UserDao proxy =
                (UserDao) new CGLibProxyFactor(dao).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
