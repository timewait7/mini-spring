package com.tw.minispring.beans.factory;

import com.tw.minispring.beans.BeansException;

import java.util.Map;

/**
 * @Author: linfeng
 * @Date: 2023/6/12 8:26 上午
 */
public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
