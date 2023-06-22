package com.tw.minispring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 6:51 下午
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";
}
