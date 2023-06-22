package com.tw.minispring.extend;

import com.tw.minispring.bean.Car;
import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @Author: linfeng
 * @Date: 2023/6/22 3:38 下午
 */
public class PropertyPlaceholderTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:property-placeholder.xml");
        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
    }
}
