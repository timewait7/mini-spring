package com.tw.minispring.core.convert.converter;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 2:37 下午
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

    void addConverter(GenericConverter converter);
}
