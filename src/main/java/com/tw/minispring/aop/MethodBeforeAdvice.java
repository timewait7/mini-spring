package com.tw.minispring.aop;

import java.lang.reflect.Method;

/**
 * @Author: linfeng
 * @Date: 2023/6/21 4:11 下午
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
