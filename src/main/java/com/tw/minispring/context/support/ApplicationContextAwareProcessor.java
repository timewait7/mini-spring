package com.tw.minispring.context.support;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.config.BeanPostProcessor;
import com.tw.minispring.context.ApplicationContext;
import com.tw.minispring.context.ApplicationContextAware;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 10:12 上午
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
