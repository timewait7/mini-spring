package com.tw.minispring.beans.factory.config;

import com.tw.minispring.beans.factory.HierarchicalBeanFactory;
import com.tw.minispring.core.convert.ConversionService;
import com.tw.minispring.util.StringValueResolver;

/**
 * @Author: linfeng
 * @Date: 2023/6/12 8:33 上午
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);

    void setConversionService(ConversionService conversionService);

    ConversionService getConversionService();
}
