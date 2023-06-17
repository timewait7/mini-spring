package com.tw.minispring.context.support;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 3:47 下午
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    /**
     * 创建BeanFactory，并加载BeanDefinition
     * @throws BeansException
     */
    @Override
    protected final void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

    @Override
    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
