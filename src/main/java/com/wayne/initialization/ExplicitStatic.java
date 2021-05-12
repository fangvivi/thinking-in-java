package com.wayne.initialization;

/**
 *
 * @author wayne
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("main()");
        Cups.cup1.f(99);
    }
    // static Cups cups1 = new Cups();
    // static Cups cups2 = new Cups();

    /*
    注释掉 Cups.cup1.f(99); 的输出
    Cup(1)
    Cup(2) 虽然静态资源被访问两次，但静态块只执行一次
    Cups()
    Cups() 调用两次构造方法
    main() 静态变量初始化完成，才会执行main()
    */

    /*
    注释掉 static Cups cups1 = new Cups();
        static Cups cups2 = new Cups();
        的输出

    main()
    Cup(1)
    Cup(2)
    f(99)
    */
}

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }
    void f(int marker){
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups() {
        System.out.println("Cups()");
    }
}