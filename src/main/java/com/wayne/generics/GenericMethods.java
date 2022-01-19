package com.wayne.generics;

/**
 * 泛型方法
 * 要定义泛型方法，请将泛型参数列表放置在返回值之前
 * @author wayne
 */
public class GenericMethods {
    public <T> void f(T t){
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f("a");
        genericMethods.f(Integer.valueOf(1));
    }
}
