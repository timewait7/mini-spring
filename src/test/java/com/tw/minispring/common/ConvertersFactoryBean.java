package com.tw.minispring.common;

import com.tw.minispring.beans.factory.xml.FactoryBean;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 4:09 下午
 */
public class ConvertersFactoryBean implements FactoryBean<Set<?>> {
    @Override
    public Set<?> getObject() throws Exception {
        Set<Object> converters = new HashSet<>();
        StringToLocalDateConverter converter = new StringToLocalDateConverter("yyyy-MM-dd");
        converters.add(converter);
        return converters;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
