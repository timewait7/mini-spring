package com.tw.minispring.aop.aspectj;

import com.tw.minispring.aop.Pointcut;
import com.tw.minispring.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @Author: linfeng
 * @Date: 2023/6/21 4:30 下午
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
        pointcut = new AspectJExpressionPointcut(expression);
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }
}
