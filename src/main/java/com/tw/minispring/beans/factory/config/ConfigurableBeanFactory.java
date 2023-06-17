package com.tw.minispring.beans.factory.config;

import com.tw.minispring.beans.factory.HierarchicalBeanFactory;
import com.tw.minispring.beans.factory.support.BeanDefinitionRegistry;

/**
 * @Author: linfeng
 * @Date: 2023/6/12 8:33 上午
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, BeanDefinitionRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
