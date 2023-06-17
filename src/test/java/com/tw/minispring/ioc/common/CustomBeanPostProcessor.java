package com.tw.minispring.ioc.common;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.config.BeanPostProcessor;
import com.tw.minispring.ioc.bean.Car;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 1:54 下午
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization");
        if ("car".equals(beanName)) {
            ((Car) bean).setBrand("lamborghini");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization");
        return bean;
    }
}
