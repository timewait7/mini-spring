package com.tw.minispring.ioc;

import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import com.tw.minispring.bean.Car;
import com.tw.minispring.bean.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 3:59 下午
 */
public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        Person person = applicationContext.getBean("person", Person.class);
        assertThat(person.getName()).isEqualTo("ivy");
        System.out.println(person);

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
        System.out.println(car);
    }
}
