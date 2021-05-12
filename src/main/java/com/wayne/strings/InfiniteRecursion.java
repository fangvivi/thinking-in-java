package com.wayne.strings;


import java.util.ArrayList;
import java.util.List;

/**
 * 没有意识的递归
 * @author wayne
 */
public class InfiniteRecursion {
    /**
     * 打印出当前对象的地址
     * @return
     */
    @Override
    public String toString() {
        /*
        此处如果使用this，因为引用跟在”String +“之后，这里会进行类型转换，
        将this转换成String，通过调用此对象的toString方法，因此会发生递归调用，
        正确的做法应该是调用Object的toString方法，也就是super.toString()
         */
        // return " InfiniteRecursion address: " + this + "\n";
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
