package com.tw.minispring.context.event;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.BeanFactory;
import com.tw.minispring.beans.factory.BeanFactoryAware;
import com.tw.minispring.context.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:31 下午
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationContextEvent>> applicationListeners = new HashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationContextEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
