package com.tw.minispring.ioc;

import com.tw.minispring.PropertyValue;
import com.tw.minispring.PropertyValues;
import com.tw.minispring.beans.factory.config.BeanDefinition;
import com.tw.minispring.beans.factory.support.DefaultListableBeanFactory;
import com.tw.minispring.ioc.bean.Person;
import com.tw.minispring.ioc.service.HelloService;
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

    @Test
    public void testPopulateBeanWithPropertyValues() {
        // 创建工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "zhang3"));
        propertyValues.addPropertyValue(new PropertyValue("age", "19"));

        // 注册bean定义
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("aPerson", beanDefinition);

        // 获取bean
        Person person = (Person) beanFactory.getBean("aPerson");
        assertThat(person).isNotNull();
        assertThat(person.getName()).isEqualTo("zhang3");
        assertThat(person.getAge()).isEqualTo(19);
        System.out.println(person);
    }
}
