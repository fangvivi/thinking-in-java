package com.wayne.generics;

/**
 * 元祖
 * 使用final实现只读
 * @author wayne
 */
public class Tuple2<A, B> {
    public final A a;
    public final B b;

    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public String rep(){
        return a + "," + b;
    }

    @Override
    public String toString() {
        return rep();
    }
}
