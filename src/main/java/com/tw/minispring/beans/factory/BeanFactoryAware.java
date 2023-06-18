package com.tw.minispring.beans.factory;

import com.tw.minispring.beans.BeansException;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 9:58 上午
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
