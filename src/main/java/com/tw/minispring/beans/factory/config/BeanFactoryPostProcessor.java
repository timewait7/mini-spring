package com.tw.minispring.beans.factory.config;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 1:08 下午
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在BeanDefinition加载完后，在bean实例化前，提供修改BeanDefinition属性值的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
