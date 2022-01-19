package com.wayne.generics;

/**
 * 使用<? super Integer>通配符表示：
 * 允许调用set(? super Integer)方法传入Integer的引用；
 * 不允许调用get()方法获得Integer的引用。
 * 即一句话总结：使用super通配符表示可以写，不能读
 * @author wayne
 */
public class Super {

    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst()+" "+p1.getLast());
        System.out.println(p2.getFirst()+" "+p2.getLast());
    }


    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
        // 使用super通配符表示可以写，不能读
    }


}
