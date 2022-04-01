package com.wayne.java8.behavior_parameter;

import com.wayne.java8.basic.Apple;

/**
 * @author wayne
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
