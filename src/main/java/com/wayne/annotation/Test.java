package com.wayne.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target 注解表示，定义的这个注解放在哪里（类上、方法上等等）
 * Retention 注解表示，定义的注解在哪里可用（源码、字节码文件、运行时）
 *
 * 注解可以包含元素，有点像接口的方法
 * 不含任何元素的注解是标记注解
 * @author wayne
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
