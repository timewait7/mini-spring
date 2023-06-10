package com.tw.minispring.ioc;

import com.tw.minispring.beans.factory.BeanFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanFactoryTest {

    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new BeanFactory();

        beanFactory.registerBean("helloService", new HelloService());

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");

        assertThat(helloService).isNotNull();
        assertThat(helloService.sayHello()).isEqualTo("hello");
    }

    class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}
