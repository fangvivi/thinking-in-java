package com.wayne.java8.behavior_parameter;

import com.wayne.java8.basic.Apple;

/**
 * 判断苹果是否是绿色的
 * @author wayne
 */
public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
