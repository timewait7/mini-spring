package com.tw.minispring.beans.factory.config;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.BeanFactory;

/**
 * @Author: linfeng
 * @Date: 2023/6/12 8:35 上午
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
