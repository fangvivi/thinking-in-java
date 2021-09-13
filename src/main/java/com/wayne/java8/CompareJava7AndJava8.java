package com.wayne.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @author wayne
 */
public class CompareJava7AndJava8 {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        // 经过测试可以看到，在此场景下，流处理的方法性能会低于java7的方法
        // 82 ms，5次平均值
        // List<String> lowCaloricDishesNamesInJava7 = getLowCaloricDishesNamesInJava8(Dish.menu);

        // 3 ms, 5次平均值
        List<String> lowCaloricDishesNamesInJava7 = getLowCaloricDishesNamesInJava7(Dish.menu);

        long end = System.currentTimeMillis();
        System.out.println(end-begin);
        for (String s : lowCaloricDishesNamesInJava7) {
            System.out.println(s);
        }
    }

    /**
     * java7中处理集合的方法
     * 找出低于400卡路里的食物，并按照热量排序，返回符合条件的食物名称列表
     * @param dishes 待筛选的食物列表
     * @return 符合要求的食物名称列表
     */
    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        // 先找出所有卡路里低于400的食物
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if(dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }
        // 用于保存食物名称的列表
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });

        for (Dish lowCaloricDish : lowCaloricDishes) {
            lowCaloricDishesName.add(lowCaloricDish.getName());
        }
        return lowCaloricDishesName;
    }

    /**
     * java8中使用流和lambda表达式来处理集合
     * 找出低于400卡路里的食物，并按照热量排序，返回符合条件的食物名称列表
     * @param dishes 待筛选的食物列表
     * @return 符合要求的食物名称列表
     */
    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(a -> a.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    /**
     * getLowCaloricDishesNamesInJava8不使用lambda表达式的版本
     * @param dishes 待筛选的食物列表
     * @return 符合要求的食物名称列表
     */
    public static List<String> getLowCaloricDishesNamesInJava8NoLambda(List<Dish> dishes){
        Stream<Dish> stream = dishes.stream();
        Stream<Dish> dishLowCaloric = stream.filter(new Predicate<Dish>() {
            @Override
            public boolean test(Dish dish) {
                return dish.getCalories() < 400;
            }
        });
        Stream<Dish> sorted = dishLowCaloric.sorted(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        Stream<String> objectStream = sorted.map(new Function<Dish, String>() {

            @Override
            public String apply(Dish dish) {
                return dish.getName();
            }
        });

        return objectStream.collect(Collectors.toList());
    }
}
