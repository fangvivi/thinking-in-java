package com.wayne.java8.behavior_parameter;

import com.wayne.java8.basic.Apple;

/**
 * 封装选择苹果的策略
 * 根据苹果的某个属性。来返回boolean值
 * @author wayne
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
