package com.wayne.java8.behavior_parameter;

import com.wayne.java8.basic.Apple;

/**
 * 判断苹果是否是重的苹果
 * @author wayne
 */
public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
