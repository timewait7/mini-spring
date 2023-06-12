package com.tw.minispring.beans.factory;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author: linfeng
 * @Date: 2023/6/12 8:36 上午
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
