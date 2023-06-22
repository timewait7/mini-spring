package com.tw.minispring.aop.framework.autoproxy;

import com.tw.minispring.aop.*;
import com.tw.minispring.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.tw.minispring.aop.framework.ProxyFactory;
import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.PropertyValues;
import com.tw.minispring.beans.factory.BeanFactory;
import com.tw.minispring.beans.factory.BeanFactoryAware;
import com.tw.minispring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.tw.minispring.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 2:28 下午
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isInfrastructureClass(beanClass)) {
            return null;
        }

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        try {
            for (AspectJExpressionPointcutAdvisor advisor : advisors) {
                ClassFilter classFilter = advisor.getPointcut().getClassFilter();
                if (classFilter.matches(beanClass)) {
                    AdvisedSupport advisedSupport = new AdvisedSupport();
                    Object bean = beanFactory.getBean(beanName);
                    TargetSource targetSource = new TargetSource(bean);
                    advisedSupport.setTargetSource(targetSource);
                    advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                    advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                    return new ProxyFactory(advisedSupport).getProxy();
                }
            }
        } catch (Exception e) {
            throw new BeansException("Error create proxy bean for: " + beanName, e);
        }
        return null;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) ||
                Pointcut.class.isAssignableFrom(beanClass) ||
                Advisor.class.isAssignableFrom(beanClass);

    }
}
