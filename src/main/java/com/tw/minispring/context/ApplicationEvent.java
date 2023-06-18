package com.tw.minispring.context;

import java.util.EventObject;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:22 下午
 */
public class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
