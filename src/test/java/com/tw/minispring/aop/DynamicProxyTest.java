package com.tw.minispring.aop;

import com.tw.minispring.aop.aspectj.AspectJExpressionPointcut;
import com.tw.minispring.aop.framework.CglibAopProxy;
import com.tw.minispring.aop.framework.JdkDynamicAopProxy;
import com.tw.minispring.aop.framework.ProxyFactory;
import com.tw.minispring.common.WorldServiceInterceptor;
import com.tw.minispring.service.WorldService;
import com.tw.minispring.service.WorldServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: linfeng
 * @Date: 2023/6/21 2:38 下午
 */
public class DynamicProxyTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService wordService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(wordService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* com.tw.minispring.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCglibDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new CglibAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testProxyFactory() throws Exception {
        // 使用JDK动态代理
        advisedSupport.setProxyTargetClass(false);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();

        // 使用CGLIB动态代理
        advisedSupport.setProxyTargetClass(true);
        proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }
}
