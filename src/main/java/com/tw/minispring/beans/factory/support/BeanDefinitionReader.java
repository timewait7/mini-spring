package com.tw.minispring.beans.factory.support;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.core.io.Resource;
import com.tw.minispring.core.io.ResourceLoader;

/**
 * @Author: linfeng
 * @Date: 2023/6/12 8:38 上午
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;

    void loadBeanDefinitions(Resource resource) throws BeansException;
}
