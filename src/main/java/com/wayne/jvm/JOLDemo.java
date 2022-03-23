package com.wayne.jvm;

import com.wayne.strings.Groups;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author wayne
 */
public class JOLDemo {
    static class A{
        int a;
        double b;
        Groups c = new Groups();
    }
    public static void main(String[] args) {
        JOLDemo.A a = new JOLDemo.A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
