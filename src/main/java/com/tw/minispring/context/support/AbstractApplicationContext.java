package com.tw.minispring.context.support;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.ConfigurableListableBeanFactory;
import com.tw.minispring.beans.factory.config.BeanFactoryPostProcessor;
import com.tw.minispring.beans.factory.config.BeanPostProcessor;
import com.tw.minispring.context.ConfigurableApplicationContext;
import com.tw.minispring.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 3:27 下午
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();

        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 在实例化bean之前，执行BeanFactoryPostProcessor，修改BeanDefinition
        invokeBeanFactoryPostProcessors(beanFactory);

        // 在实例化bean之前，注册BeanPostProcessor
        registerBeanPostProcessors(beanFactory);

        // 提前实例化单例bean
        beanFactory.preInstantiateSingletons();
    }

    /**
     * 创建BeanFactory，并加载BeanDefinition
     * @throws BeansException
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 在bean实例化之前，执行BeanFactoryPostProcessor
     * @param beanFactory
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor processor : beanFactoryPostProcessorMap.values()) {
            processor.postProcessorBeanFactory(beanFactory);
        }
    }

    protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor processor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(processor);
        }
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public Object getBean(String name) throws BeansException {
       return getBeanFactory().getBean(name);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    public abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public void close() {
        doClose();
    }

    @Override
    public void registerShutdownHook() {
        Thread shutdownHook = new Thread(this::doClose);
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    protected void doClose() {
        destroyBeans();
    }

    protected void destroyBeans() {
        getBeanFactory().destroySingletons();
    }
}
