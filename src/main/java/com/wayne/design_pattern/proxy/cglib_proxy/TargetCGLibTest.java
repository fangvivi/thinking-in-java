package com.wayne.design_pattern.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author wayne
 */
public class TargetCGLibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject = (TargetObject) enhancer.create();
        System.out.printf("输出创建的代理对象：%s%n",targetObject);

        System.out.printf("方法输出：%s%n",targetObject.method1("hello world"));

        System.out.println("------------------------------------");

        System.out.printf("方法输出：%s%n",targetObject.method2(100));

        System.out.println("------------------------------------");

        System.out.printf("方法输出：%s%n",targetObject.method3(200));

        System.out.println("------------------------------------");
    }
}
