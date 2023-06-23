package com.tw.minispring.core.convert;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 2:39 下午
 */
public interface ConversionService {

    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);
}
