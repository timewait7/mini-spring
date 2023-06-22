package com.tw.minispring.stereotype;

import java.lang.annotation.*;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 5:25 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
