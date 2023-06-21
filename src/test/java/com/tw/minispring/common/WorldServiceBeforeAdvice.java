package com.tw.minispring.common;

import com.tw.minispring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: linfeng
 * @Date: 2023/6/21 4:17 下午
 */
public class WorldServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice: do something before the earth explodes");
    }
}
