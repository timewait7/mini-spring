package com.tw.minispring.context.annotation;

import java.lang.annotation.*;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 5:27 下午
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
