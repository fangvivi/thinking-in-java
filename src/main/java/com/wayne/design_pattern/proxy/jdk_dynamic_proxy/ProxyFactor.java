package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * 基于JDK实现动态代理，可以为不同类型对象创建代理
 * @author wayne
 */
public class ProxyFactor {

    /**
     * 维护被代理对象
     */
    private Object target;

    public ProxyFactor(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开启事务");
                    method.invoke(target, args);
                    System.out.println("提交事务");
                    return null;
                });
    }
}
