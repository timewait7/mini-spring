package com.tw.minispring.context;

import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.factory.Aware;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 9:59 上午
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
