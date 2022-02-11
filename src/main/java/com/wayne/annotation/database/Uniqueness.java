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
public @interface Uniqueness {
    /** 这样可以改变注解元素的默认值 */
    Constraints constraints() default @Constraints(unique = true);
}
