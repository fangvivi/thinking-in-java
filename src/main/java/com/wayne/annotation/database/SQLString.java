package com.wayne.annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wayne
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    /**
     * 如果在注解中定义了名为value的元素，使用注解的时候
     * value 为唯一一个需要赋值的元素
     * 你就不需要使用名—值对的语法，
     * 你只需要在括号中给出 value 元素的值即可
     * */
    int value() default 0;

    String name() default "";

    /** 这个元素的默认值是，所有元素都为默认值的 @Constraints 注解 */
    Constraints constraints() default @Constraints;
}
