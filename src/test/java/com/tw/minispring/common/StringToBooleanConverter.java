package com.tw.minispring.common;

import com.tw.minispring.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.Set;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 3:25 下午
 */
public class StringToBooleanConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Boolean.class));
    }

    @Override
    public Object convert(Object source, Class sourceType, Class targetType) {
        return Boolean.valueOf((String) source);
    }
}
