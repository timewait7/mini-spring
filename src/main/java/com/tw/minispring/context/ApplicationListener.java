package com.tw.minispring.context;

import java.util.EventListener;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:23 下午
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
