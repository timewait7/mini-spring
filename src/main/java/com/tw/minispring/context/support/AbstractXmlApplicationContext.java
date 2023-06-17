package com.tw.minispring.context.support;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.support.DefaultListableBeanFactory;
import com.tw.minispring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 3:52 下午
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
