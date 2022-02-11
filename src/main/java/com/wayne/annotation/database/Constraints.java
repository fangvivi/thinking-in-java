package com.wayne.annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表字段约束，用来接收数据库表的元数据
 * @author wayne
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    /** 是否为主键 */
    boolean primaryKey() default false;
    /** 是否允许为空 */
    boolean allowNull() default true;
    /** 是否唯一 */
    boolean unique() default false;
}
