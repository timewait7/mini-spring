package com.tw.minispring.aop;

import java.lang.reflect.Method;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 2:58 下午
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
