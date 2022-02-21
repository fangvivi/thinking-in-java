package com.wayne.design_pattern.proxy.cglib_proxy;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 回调方法过滤
 * @author wayne
 */
public class TargetMethodCallbackFilter implements CallbackFilter {
    /**
     *
     * 返回的值为数字，代表了Callback数组中的索引位置，要到用的Callback
     * Map a method to a callback.
     * @param method the intercepted method
     * @return the index into the array of callbacks
     * (as specified by {@link Enhancer#setCallbacks}) to use for the method,
     */
    @Override
    public int accept(Method method) {
        if(method.getName().equals("method1")){
            System.out.println("filter method1 ==0");
            return 0;
        }
        if(method.getName().equals("method2")){
            System.out.println("filter method2 ==1");
            return 1;
        }
        if(method.getName().equals("method3")){
            System.out.println("filter method3 ==2");
            return 2;
        }
        return 0;
    }
}
