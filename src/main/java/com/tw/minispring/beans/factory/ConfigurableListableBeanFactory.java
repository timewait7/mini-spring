package com.tw.minispring.beans.factory;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.config.AutowireCapableBeanFactory;
import com.tw.minispring.beans.factory.config.BeanDefinition;
import com.tw.minispring.beans.factory.config.BeanPostProcessor;
import com.tw.minispring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author: linfeng
 * @Date: 2023/6/12 8:36 上午
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
