package com.tw.minispring.common;

import com.tw.minispring.core.convert.converter.Converter;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 3:20 下午
 */
public class StringToIntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }
}
