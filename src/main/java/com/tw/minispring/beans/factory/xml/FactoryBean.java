package com.tw.minispring.beans.factory.xml;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 11:04 上午
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    boolean isSingleton();
}
