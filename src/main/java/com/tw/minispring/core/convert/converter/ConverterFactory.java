package com.tw.minispring.core.convert.converter;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 2:13 下午
 */
public interface ConverterFactory<S, R> {

    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
