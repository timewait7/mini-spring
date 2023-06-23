package com.tw.minispring.core.convert.support;

import com.tw.minispring.core.convert.converter.Converter;
import com.tw.minispring.core.convert.converter.ConverterFactory;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 3:10 下午
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<T>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            if (source.length() == 0) {
                return null;
            }
            if (targetType.equals(Integer.class)) {
                return (T) Integer.valueOf(source);
            }
            if (targetType.equals(Long.class)) {
                return (T) Long.valueOf(source);
            }
            // 其他数字类型
            throw new IllegalArgumentException("Cannot convert String [" + source + "] " +
                    "to target class [" + targetType.getName() + "]");
        }
    }
}
