package com.tw.minispring.ioc;

import com.tw.minispring.bean.Car;
import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 10:52 上午
 */
public class BeanScopeTest {

    @Test
    public void testPrototypeScope() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean-scope.xml");

        Car car1 = applicationContext.getBean("car", Car.class);
        Car car2 = applicationContext.getBean("car", Car.class);

        assertThat(car1 != car2).isTrue();
    }
}
