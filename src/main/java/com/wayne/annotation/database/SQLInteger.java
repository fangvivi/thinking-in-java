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
public @interface SQLInteger {
    String name() default "";
    /** 这个元素的默认值是，所有元素都为默认值的 @Constraints 注解 */
    Constraints constraints() default @Constraints;
}
