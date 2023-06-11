package com.tw.minispring;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 11:01 上午
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
