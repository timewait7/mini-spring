package com.tw.minispring.ioc;

import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import com.tw.minispring.ioc.service.HelloService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 10:04 上午
 */
public class AwareTest {

    @Test
    public void testAware() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        assertThat(helloService.getBeanFactory()).isNotNull();
        assertThat(helloService.getApplicationContext()).isNotNull();
    }
}
