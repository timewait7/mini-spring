package com.tw.minispring.beans.factory;

import com.tw.minispring.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
