package com.tw.minispring.context.support;

import com.tw.minispring.beans.factory.InitializingBean;
import com.tw.minispring.beans.factory.xml.FactoryBean;
import com.tw.minispring.core.convert.ConversionService;
import com.tw.minispring.core.convert.converter.Converter;
import com.tw.minispring.core.convert.converter.ConverterFactory;
import com.tw.minispring.core.convert.converter.ConverterRegistry;
import com.tw.minispring.core.convert.converter.GenericConverter;
import com.tw.minispring.core.convert.support.DefaultConversionService;
import com.tw.minispring.core.convert.support.GenericConversionService;

import java.util.Set;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 3:38 下午
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    private Set<?> converters;

    private GenericConversionService conversionService;

    @Override
    public void afterPropertiesSet() throws Exception {
        conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);
    }

    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }

    private void registerConverters(Set<?> converters, ConverterRegistry registry) {
        if (converters != null) {
            for (Object converter : converters) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converters instanceof Converter<?, ?>) {
                    registry.addConverter(((Converter<?, ?>) converter));
                } else if (converters instanceof ConverterFactory<?, ?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implement one of the " +
                            "Converter, ConverterFactory, or GenericConverter interfaces");
                }
            }
        }
    }
}
