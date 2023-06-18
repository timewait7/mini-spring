package com.tw.minispring.common;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.PropertyValue;
import com.tw.minispring.beans.PropertyValues;
import com.tw.minispring.beans.factory.ConfigurableListableBeanFactory;
import com.tw.minispring.beans.factory.config.BeanDefinition;
import com.tw.minispring.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 1:21 下午
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "ivy"));
    }
}
