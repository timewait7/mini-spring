package com.tw.minispring.beans.factory.config;

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
