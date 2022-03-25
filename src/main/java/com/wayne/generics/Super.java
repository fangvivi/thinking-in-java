package com.wayne.generics;

/**
 * 声明通配符是由某个特定类的任何父类
 * 因为 Integer 是下界，所以你知道向这样的 List 中添加 Number 是不安全的，
 * 因为这将使这个 List 敞开口子，从而可以向其中添加非 Integer类型的对象，而这是违反静态类型安全的。
 * 使用super通配符表示可以写，不能读
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


    /**
     * 允许调用set(? super Integer)方法传入Integer的引用；
     * 不允许调用get()方法获得Integer的引用。
     * <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
     */
    static void setSame(Pair<? super Integer> p, Integer n) {
        Number number = new Double(2.0);
        //p.setFirst(number);
        p.setFirst(n);
        p.setLast(n);
        // 不允许调用get()方法获得Integer的引用。
        //Integer a = p.getLast();
        Object last = p.getLast();
    }


}
