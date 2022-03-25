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
        genericMethods.<String>f("a");
        genericMethods.f(1);
    }
}

class ArrayAlg{

    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }
    public static <T extends Comparable> T min ( T[] a ) {
        if (a == null || a.length == 0){
            return null;
        }
        T smallest = a [0];
        for ( int i = 1 ; i < a . length; i++ ) {
            if ( smallest.compareTo(a[i]) > 0 ) {
                smallest = a [ i ] ;
            }
        }
        return smallest ;
    }
}
