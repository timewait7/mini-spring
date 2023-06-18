package com.tw.minispring.common.event;

import com.tw.minispring.context.ApplicationListener;
import com.tw.minispring.context.event.ContextRefreshedEvent;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:45 下午
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
