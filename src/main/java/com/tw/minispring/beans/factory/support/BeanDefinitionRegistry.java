package com.tw.minispring.beans.factory.support;

import com.tw.minispring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void register(String beanName, BeanDefinition beanDefinition);
}
