package com.wayne.design_pattern.proxy.cglib_proxy.extend;

/**
 * @author wayne
 */
public class TargetObject {

    public String method1(String paramName) {
        return paramName;
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "输出原对象：TargetObject："+ getClass();
    }
}
