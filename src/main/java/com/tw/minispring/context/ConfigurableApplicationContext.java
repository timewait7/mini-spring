package com.tw.minispring.context;

import com.tw.minispring.beans.BeansException;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 3:26 下午
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;
}
