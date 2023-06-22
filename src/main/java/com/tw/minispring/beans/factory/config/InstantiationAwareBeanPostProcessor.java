package com.tw.minispring.beans.factory.config;

import com.tw.minispring.beans.BeansException;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 2:27 下午
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
