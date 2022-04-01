package com.wayne.java8.behavior_parameter;

import com.wayne.java8.basic.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wayne
 */
public class AppleFilter {

    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList();
        apples.add(new Apple("green",200));
        apples.add(new Apple("red",150));
        apples.add(new Apple("yellow",160));
        List<Apple> appleList = filterApples(apples, new AppleHeavyWeightPredicate());
        System.out.println(appleList);
    }

}
