package com.tw.minispring.ioc;

import com.tw.minispring.beans.factory.config.BeanDefinition;
import com.tw.minispring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanFactoryTest {

    @Test
    public void testGetBean() {
//        BeanFactory beanFactory = new BeanFactory();
//
//        beanFactory.registerBean("helloService", new HelloService());
//
//        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
//
//        assertThat(helloService).isNotNull();
//        assertThat(helloService.sayHello()).isEqualTo("hello");
    }

    @Test
    public void testGetBean2() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertThat(helloService).isNotNull();
        helloService.sayHello();
    }
}
