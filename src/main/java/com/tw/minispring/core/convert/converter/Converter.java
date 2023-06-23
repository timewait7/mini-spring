package com.tw.minispring.core.convert.converter;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 2:12 下午
 */
public interface Converter<S, T> {

    T convert(S source);
}
