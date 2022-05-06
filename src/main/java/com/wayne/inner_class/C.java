package com.wayne.inner_class;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class C extends A{
    private String c = "c";
    public static String d = "d";
    public void createLocalObject(final String e){
        final String f = "f";
        int i = 0;

        /**
        * 局部类
        */
        class Local extends B{
            String g = "g";
            public void printVars(){
                // this.g
                log.debug(g);
                // 外层类方法的final修饰的局部变量
                log.debug(f);
                // 外层类方法的final修饰的局部变量
                log.debug(e);
                // 外层类的静态变量
                log.debug(d);
                // 外层类的私有成员变量
                log.debug(c);
                // 父类的字段
                log.debug(b);
                // 外层类的父类的字段
                log.debug(a);
            }
        }

        Local l = new Local();
        l.printVars();
    }

    public static void main(String[] args) {
        new C().createLocalObject("e");
    }
}
