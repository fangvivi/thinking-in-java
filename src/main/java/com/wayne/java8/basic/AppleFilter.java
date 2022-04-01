package com.wayne.java8.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 */
public class AppleFilter {
    /**
     * 挑选出所有的绿苹果
     * @param inventory 库存
     * @return 挑选出来的绿苹果
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if("green".equals(apple.getColor())){
                greenApples.add(apple);
            }
        }
        return greenApples;
    }

    /**
     * 挑选出重量大于150克的苹果
     * @param inventory 库存
     * @return 所有重量大于150克的苹果
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getWeight() > 150){
                greenApples.add(apple);
            }
        }
        return greenApples;
    }

    /**
     * 挑选出所有的绿苹果
     * @param inventory 库存
     * @return 挑选出来的绿苹果
     */
    public static List<Apple> filterGreenApplesJava8(List<Apple> inventory){
        // 绿苹果
        //return filterApples(inventory, Apple::isGreenApple);
        return filterApples(inventory, (Apple a)->"green".equals(a.getColor()));
    }

    /**
     * 挑选出重量大于150克的苹果
     * @param inventory 库存
     * @return 所有重量大于150克的苹果
     */
    public static List<Apple> filterHeavyApplesJava8(List<Apple> inventory){
        // 重量超过150克的苹果
        //return filterApples(inventory, Apple::isHeavyApple);
        // lambda表达式（匿名函数）可以节省只写一次的方法代码
        return filterApples(inventory, (Apple a)->a.getWeight() > 150);
    }

    /**
     * 通用苹果筛选逻辑，可以传递具体的筛选方法引用到这个方法中
     * @param inventory 库存
     * @param p 筛选条件
     * @return 满足筛选条件的苹果
     */
    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)){
               apples.add(apple);
            }
        }
        return apples;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList();
        apples.add(new Apple("green",200));
        apples.add(new Apple("red",150));
        apples.add(new Apple("yellow",160));
        System.out.println(filterGreenApplesJava8(apples));
        System.out.println(filterHeavyApplesJava8(apples));

        List<Apple> appleList = apples.stream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());
        System.out.println(appleList);

    }
}
