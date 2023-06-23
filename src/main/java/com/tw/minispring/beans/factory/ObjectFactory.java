package com.tw.minispring.beans.factory;

import com.tw.minispring.beans.BeansException;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 5:39 下午
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
