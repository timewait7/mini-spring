package com.tw.minispring.context;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:24 下午
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
