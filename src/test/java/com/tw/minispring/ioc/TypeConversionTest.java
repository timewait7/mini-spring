package com.tw.minispring.ioc;

import com.tw.minispring.bean.Car;
import com.tw.minispring.common.StringToBooleanConverter;
import com.tw.minispring.common.StringToIntegerConverter;
import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import com.tw.minispring.core.convert.converter.Converter;
import com.tw.minispring.core.convert.support.GenericConversionService;
import com.tw.minispring.core.convert.support.StringToNumberConverterFactory;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 3:17 下午
 */
public class TypeConversionTest {

    @Test
    public void testStringToIntegerConverter() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer num = converter.convert("999");
        assertThat(num).isEqualTo(999);
    }

    @Test
    public void testStringToNumberConverterFactory() {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();

        Converter<String, Integer> stringToIntegerConverter = converterFactory.getConverter(Integer.class);
        Integer intNum = stringToIntegerConverter.convert("999");
        assertThat(intNum).isEqualTo(999);

        Converter<String, Long> stringToLongConverter = converterFactory.getConverter(Long.class);
        Integer longNum = stringToIntegerConverter.convert("999");
        assertThat(longNum).isEqualTo(999L);
    }

    @Test
    public void testGenericConverter() {
        StringToBooleanConverter converter = new StringToBooleanConverter();
        Boolean flag = (Boolean) converter.convert("true", String.class, Boolean.class);
        assertThat(flag).isTrue();
    }

    @Test
    public void testGenericConversionService() {
        GenericConversionService conversionService = new GenericConversionService();

        conversionService.addConverter(new StringToIntegerConverter());
        assertThat(conversionService.canConvert(String.class, Integer.class)).isTrue();
        Integer intNum = conversionService.convert("8888", Integer.class);
        assertThat(intNum).isEqualTo(8888);

        conversionService.addConverterFactory(new StringToNumberConverterFactory());
        assertThat(conversionService.canConvert(String.class, Long.class)).isTrue();
        Long longNum = conversionService.convert("8888", Long.class);
        assertThat(longNum).isEqualTo(8888);

        conversionService.addConverter(new StringToBooleanConverter());
        assertThat(conversionService.canConvert(String.class, Boolean.class)).isTrue();
        Boolean flag = conversionService.convert("true", Boolean.class);
        assertThat(flag).isTrue();
    }

    @Test
    public void testConversionService() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:type-converter.xml");
        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getPrice()).isEqualTo(1000000);
        assertThat(car.getProducedDate()).isEqualTo(LocalDate.of(2021, 1, 1));
    }
}
