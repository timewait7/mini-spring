package com.tw.minispring.aop;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 2:57 下午
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
