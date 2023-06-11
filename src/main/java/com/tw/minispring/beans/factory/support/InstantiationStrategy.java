package com.tw.minispring.beans.factory.support;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.config.BeanDefinition;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 10:12 上午
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
