package com.wayne.design_pattern.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于CGlib实现动态代理
 * @author wayne
 */
public class CGLibProxyFactor implements MethodInterceptor {
    /**
     * 维护被代理对象
     */
    private Object target;

    public CGLibProxyFactor(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        //工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调函数
        en.setCallback(this);
        // 创建代理对象
        return en.create();

    }

    /**
     * 使用代理对象，调用原方法的时候，会调用这个方法
     */
    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }
}
