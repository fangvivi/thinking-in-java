package com.wayne.clone;

/**
 * @author wayne
 */
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A();
        B b = new B("b");
        C c = new C("c");
        a.setB(b);
        a.setC(c);
        A clone = a.clone();
        // false
        System.out.println(a==clone);
        // true 浅拷贝
        System.out.println(a.getB()==clone.getB());

    }
}
