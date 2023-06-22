package com.tw.minispring.beans.factory;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.PropertyValue;
import com.tw.minispring.beans.PropertyValues;
import com.tw.minispring.beans.factory.ConfigurableListableBeanFactory;
import com.tw.minispring.beans.factory.config.BeanDefinition;
import com.tw.minispring.beans.factory.config.BeanFactoryPostProcessor;
import com.tw.minispring.core.io.DefaultResourceLoader;
import com.tw.minispring.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 3:12 下午
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    private static final String PLACEHOLDER_PREFIX = "${";

    private static final String PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Properties properties = loadProperties();
        processProperties(beanFactory, properties);
    }

    private Properties loadProperties() {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            return properties;
        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    private void processProperties(ConfigurableListableBeanFactory beanFactory, Properties properties) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            resolvePropertyValues(beanDefinition, properties);
        }
    }

    private void resolvePropertyValues(BeanDefinition beanDefinition, Properties properties) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof String) {
                String strVal = (String) value;
                StringBuffer buf = new StringBuffer(strVal);
                int startIndex = strVal.indexOf(PLACEHOLDER_PREFIX);
                int endIndex = strVal.indexOf(PLACEHOLDER_SUFFIX);
                if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
                    String propKey = strVal.substring(startIndex + 2, endIndex);
                    String propVal = properties.getProperty(propKey);
                    buf.replace(startIndex, endIndex + 1, propVal);
                    propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), buf.toString()));
                }
            }
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
