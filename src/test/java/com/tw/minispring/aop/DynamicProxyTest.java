package com.tw.minispring.aop;

import com.tw.minispring.aop.aspectj.AspectJExpressionPointcut;
import com.tw.minispring.aop.framework.JdkDynamicAopProxy;
import com.tw.minispring.common.WorldServiceInterceptor;
import com.tw.minispring.service.WordService;
import com.tw.minispring.service.WordServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @Author: linfeng
 * @Date: 2023/6/21 2:38 下午
 */
public class DynamicProxyTest {

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WordService wordService = new WordServiceImpl();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(wordService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* com.tw.minispring.service.WordService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);

        WordService proxy = (WordService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }
}
