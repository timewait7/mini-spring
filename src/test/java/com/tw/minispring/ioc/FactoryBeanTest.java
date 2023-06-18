package com.tw.minispring.ioc;

import com.tw.minispring.bean.Car;
import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 11:21 上午
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");
        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("porsche");
    }
}
