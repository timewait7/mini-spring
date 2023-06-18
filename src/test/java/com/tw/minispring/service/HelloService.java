package com.tw.minispring.service;

import com.tw.minispring.beans.factory.BeanFactoryAware;
import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.BeanFactory;
import com.tw.minispring.context.ApplicationContext;
import com.tw.minispring.context.ApplicationContextAware;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 9:33 上午
 */
public class HelloService implements BeanFactoryAware, ApplicationContextAware {

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}