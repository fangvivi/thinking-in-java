package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于JDK实现动态代理，可以为不同类型对象创建代理
 * @author wayne
 */
public class ProxyFactory {

    /**
     * 维护被代理对象
     */
    private final Object target;

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
        // 被代理类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 被代理类实现的接口
        Class<?>[] interfaces = target.getClass().getInterfaces();
        // 代理对象关联的 invocationHandler 用来增强被代理类的方法
        InvocationHandler invocationHandler  = new InvocationHandler() {
            /**
             * @param proxy 调用这个代理方法的实例
             * @param method 对应的是接口的方法
             * @return 这里的返回值就是这个方法的返回值
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                method.invoke(target, args);
                System.out.println("关闭事务");
                return null;
            }
        };
        // 被代理类必须实现接口，这是JDK动态代理的限制
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
