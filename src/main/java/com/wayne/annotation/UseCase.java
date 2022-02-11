package com.wayne.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个注解有int元素 id，String元素 description
 * 注解的元素类型可以为：
 * 基本类型
 * Class
 * enum
 * Annotation
 * 以上类型的数组
 *
 * @author wayne
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();
    String description() default "no description";
}
