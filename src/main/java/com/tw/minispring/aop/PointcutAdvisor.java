package com.tw.minispring.aop;

/**
 * @Author: linfeng
 * @Date: 2023/6/21 4:29 下午
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
