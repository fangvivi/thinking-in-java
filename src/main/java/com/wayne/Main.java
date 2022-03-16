package com.wayne;

import com.wayne.java8.Dish;
import com.wayne.strings.Groups;
import org.openjdk.jol.info.ClassLayout;


/**
 * @author wayne
 */
public class Main {
    static class A{
        int a;
        double b;
        Groups c = new Groups();
    }
    public static void main(String[] args) {
       A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
