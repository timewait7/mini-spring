package com.tw.minispring.common.event;

import com.tw.minispring.context.ApplicationListener;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:43 下午
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(this.getClass().getName());
    }
}
