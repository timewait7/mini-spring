package com.tw.minispring.aop;

import com.tw.minispring.aop.aspectj.AspectJExpressionPointcut;
import com.tw.minispring.service.HelloService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 3:13 下午
 */
public class PointcutExpressionTest {

    @Test
    public void testPointcutExpression() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* com.tw.minispring.service.*(..))");
        Class<HelloService> clazz = HelloService.class;
        Method method = clazz.getDeclaredMethod("sayHello");
        assertThat(pointcut.matches(clazz)).isTrue();
        assertThat(pointcut.matches(method, clazz)).isTrue();
    }
}
