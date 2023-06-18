package com.tw.minispring.context.event;

import com.tw.minispring.context.ApplicationEvent;
import com.tw.minispring.context.ApplicationListener;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:29 下午
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
