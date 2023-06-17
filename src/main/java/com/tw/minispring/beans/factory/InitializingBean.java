package com.tw.minispring.beans.factory;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 6:18 下午
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
