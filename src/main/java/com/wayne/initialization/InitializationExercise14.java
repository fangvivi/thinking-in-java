package com.wayne.initialization;

/**
 * /****************** Exercise 14 *****************
 * * Create a class with a static String field that
 * * is initialized at the point of definition, and
 * * another one initialized by the static
 * * block. Add a static method that prints both
 * * fields and demonstrates that they are both
 * * initialized before they are used
 * @author wayne
 */
public class InitializationExercise14 {
    static String s1 = "窗前明月光（定义处初始化）";
    static String s2;
    static {
        s2 = "疑是地上霜（代码块中初始化）";
    }

    public static void main(String[] args) {

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        /*
        s1 = 窗前明月光（定义处初始化）
        s2 = 疑是地上霜（代码块中初始化）
        */
    }
}
