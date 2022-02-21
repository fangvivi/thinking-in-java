package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * 基于JDK实现动态代理，可以为不同类型对象创建代理
 * @author wayne
 */
public class ProxyFactory {

    /**
     * 维护被代理对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * JDK中的动态代理是通过反射类Proxy以及InvocationHandler回调接口实现的
     * Each proxy instance has an associated invocation handler.
     * When a method is invoked on a proxy instance,
     * the method invocation is encoded and dispatched to the invoke method of its invocation handler.
     * @return 被代理对象
     */
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
