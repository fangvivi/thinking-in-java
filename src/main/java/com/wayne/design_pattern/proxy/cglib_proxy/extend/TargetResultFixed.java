package com.wayne.design_pattern.proxy.cglib_proxy.extend;

import net.sf.cglib.proxy.FixedValue;

/**
 * 表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值
 * @author wayne
 */
public class TargetResultFixed implements FixedValue {
    /**
     * Return the object which the original method invocation should
     * return. This method is called for <b>every</b> method invocation.
     *
     * @return an object matching the type of the return value for every
     * method this callback is mapped to
     */
    @Override
    public Object loadObject() {
        System.out.println("锁定结果");
        /*
          整型，CallbackFilter中定义的使用FixedValue型回调的方法为getConcreteMethodFixedValue，该方法返回值为整型
         */
        Object obj = 999;
        return obj;
    }
}
