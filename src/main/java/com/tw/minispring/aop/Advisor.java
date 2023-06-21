package com.tw.minispring.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author: linfeng
 * @Date: 2023/6/21 4:28 下午
 */
public interface Advisor {

    Advice getAdvice();
}
