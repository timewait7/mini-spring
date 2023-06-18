package com.tw.minispring.common.event;

import com.tw.minispring.context.event.ApplicationContextEvent;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:43 下午
 */
public class CustomEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source) {
        super(source);
    }
}
