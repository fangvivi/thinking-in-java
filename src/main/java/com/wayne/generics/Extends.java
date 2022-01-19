package com.wayne.generics;


/**
 * extends 通配符
 * 使用类似<? extends Number>通配符作为方法参数时表示：
 * 方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst()
 * 方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n)
 *
 * 即一句话总结：使用extends通配符表示可以读，不能写
 * @author wayne
 */
public class Extends {

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }

    /**
     * 要想让add方法可以接受Pair<Integer>，就要使用<? extends Number>来声明，
     * 这个方法支持的参数类型是为Number或Number子类的Pair类型
     *
     * @return
     */
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        /* 如果参数p实际是一个Double类型，如果接受Integer类型就会出问题
         'setLast(capture<? extends java.lang.Number>)' in 'com.wayne.generic_type.Pair'
         cannot be applied to '(int)'
        p.setLast(new Integer(last.intValue()) + 100);*/

        return first.intValue() + last.intValue();
    }

    /*
    编译错误：
     java: 不兼容的类型: com.wayne.generic_type.Pair<java.lang.Integer>
    无法转换为com.wayne.generic_type.Pair<java.lang.Number>
    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
     */

}
