package com.tw.minispring.ioc.common.event;

import com.tw.minispring.context.ApplicationListener;
import com.tw.minispring.context.event.ContextClosedEvent;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:44 下午
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
