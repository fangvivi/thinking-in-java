package com.wayne.generics;

/**
 * 可以保存三个类型数据的元祖
 * @author wayne
 */
public class Tuple3<A, B, C> extends Tuple2<A, B>{
    public final  C c;

    public Tuple3(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String rep() {
        return super.rep()+","+c;
    }

    @Override
    public String toString() {
        return rep();
    }

    public static void main(String[] args) {
        Tuple3<String, String, String> tuple3 = new Tuple3<>("A", "B","C");
        System.out.println(tuple3);

    }
}
