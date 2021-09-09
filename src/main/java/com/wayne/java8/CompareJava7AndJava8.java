package com.wayne.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @author wayne
 */
public class CompareJava7AndJava8 {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
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
     * @param dishes
     * @return
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

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
