package com.wayne.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 因为注解的元素默认值不可以用null，所以难以表示元素存在或者缺失的状态
 * 这里用-1和空字符串，表示null的情况
 * @author wayne
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    int id() default -1;
    String description() default "";
}
