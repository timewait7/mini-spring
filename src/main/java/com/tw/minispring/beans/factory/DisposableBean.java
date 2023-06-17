package com.tw.minispring.beans.factory;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 6:17 下午
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
