package com.tw.minispring.beans.factory.config;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 4:08 下午
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
