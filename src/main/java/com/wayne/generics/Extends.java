package com.wayne.generics;


/**
 * 因此当你指定一个 ArrayList<? extends Number> 时，setLast 的参数就变成了 “? extends Number”。
 * 从这个描述中，编译器无法得知这里需要 Number 的哪个具体子类型，因此它不会接受任何类型的 Number。
 * 如果你先把 Integer 向上转型为 Number，也没有关系——编译器仅仅会拒绝调用像 add() 这样参数列表中涉及通配符的方法
 * 使用extends通配符表示可以读，不能写
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
     * <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）
     */
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        // 能读不能写
        //p.setLast(new Integer(last.intValue()) + 100);

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
