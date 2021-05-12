package com.wayne.initialization;

/**
 * 类的静态资源初始化
 * 1、一个类的静态资源按照代码的先后顺序进行初始化
 * 2、成员变量的初始化在构造方法之前执行
 * 3、虽然默认没有static修饰，构造方法实际上也是一个静态的方法
 * @author wayne
 */
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);

    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
    // 静态资源之间按照顺序执行
    static {
        System.out.println("static block");
    }

    /*
   输出结果
    Bowl(1)
    Bowl(2)
    Table()
    f1(1)
    Bowl(4)
    Bowl(5)
    Bowl(3)  初始化Cupboard对象的成员变量
    Cupboard()
    f1(2)
    Creating new Cupboard() in main
    Bowl(3) 成员变量初始化是在构造方法之前执行
    Cupboard()
    f1(2)
    Creating new Cupboard() in main
    Bowl(3)
    Cupboard()
    f1(2)
    f2(1)
    f3(1)
    */
}
class Bowl {

    Bowl(int marker){
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker){
        System.out.println("f1(" + marker +")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);
    Table() {
        System.out.println("Table()");
        bowl1.f1(1);
    }
    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    /**
     * 加载完静态资源会对成员变量进行初始化，在构造方法之前执行
     */
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4  = new Bowl(4);
    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int marker){
        System.out.println("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);




}



