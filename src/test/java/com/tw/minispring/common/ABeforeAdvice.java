package com.tw.minispring.common;

import com.tw.minispring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 5:28 下午
 */
public class ABeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

    }
}
