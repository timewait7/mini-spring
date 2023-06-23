package com.tw.minispring.core.convert.support;

import com.tw.minispring.core.convert.converter.ConverterRegistry;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 3:09 下午
 */
public class DefaultConversionService extends GenericConversionService {

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
