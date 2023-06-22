package com.tw.minispring.ioc;

import com.tw.minispring.bean.Car;
import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 5:49 下午
 */
public class PackageScanTest {

    @Test
    public void testPackageScan() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:package-scan.xml");
        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car).isNotNull();
        System.out.println(car);
    }
}
