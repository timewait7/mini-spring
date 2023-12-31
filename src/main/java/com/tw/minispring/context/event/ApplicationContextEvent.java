package com.tw.minispring.context.event;

import com.tw.minispring.context.ApplicationContext;
import com.tw.minispring.context.ApplicationEvent;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:25 下午
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
