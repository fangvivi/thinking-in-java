package com.wayne.design_pattern.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于CGlib实现动态代理，可以为没有实现接口的类实现代理
 * 原理是动态生成被代理类的子类，这个子类可以重新所有父类的非final方法，
 * 在调用父类方法的之前，自动调用用户实现的方法拦截逻辑
 * @author wayne
 */
public class CGLibProxyFactory implements MethodInterceptor {
    /**
     * 维护被代理对象
     */
    private Object target;

    public CGLibProxyFactory(Object target) {
        this.target = target;
    }

    public CGLibProxyFactory() {
    }

    public Object getProxyInstance(){
        //工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调函数
        // en.setCallback(new CGLibProxyFactory());
        en.setCallback(this);
        // 创建代理对象
        return en.create();

    }

    /**
     * All generated proxied methods call this method instead of the original method.
     * The original method may either be invoked by normal reflection using the Method object,
     * or by using the MethodProxy (faster).
     *
     * @param obj    "this", the enhanced object
     * @param method intercepted Method
     * @param args   argument array; primitive types are wrapped
     * @param methodProxy  used to invoke super (non-intercepted method); may be called
     *               as many times as needed
     * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
     * @throws Throwable any exception may be thrown; if so, super method will not be invoked
     * @see MethodProxy
     */
    @Override
    public Object intercept(Object obj,
                            Method method,
                            Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }
}
