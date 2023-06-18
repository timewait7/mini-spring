package com.tw.minispring.ioc;

import com.tw.minispring.bean.Car;
import com.tw.minispring.bean.Person;
import com.tw.minispring.beans.PropertyValue;
import com.tw.minispring.beans.PropertyValues;
import com.tw.minispring.beans.factory.config.BeanDefinition;
import com.tw.minispring.beans.factory.config.BeanReference;
import com.tw.minispring.beans.factory.support.DefaultListableBeanFactory;
import com.tw.minispring.service.HelloService;
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

    @Test
    public void testPopulateBeanWithBeanName() throws Exception {
        // 创建工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册Car实例
        PropertyValues carPropertyValues = new PropertyValues();
        carPropertyValues.addPropertyValue(new PropertyValue("brand", "porsche"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, carPropertyValues);
        beanFactory.registerBeanDefinition("aCar", carBeanDefinition);

        // 注册Person实例
        PropertyValues personPropertyValues = new PropertyValues();
        personPropertyValues.addPropertyValue(new PropertyValue("name", "zhang3"));
        personPropertyValues.addPropertyValue(new PropertyValue("age", 19));
        personPropertyValues.addPropertyValue(new PropertyValue("car", new BeanReference("aCar")));
        BeanDefinition personBeanDefinition = new BeanDefinition(Person.class, personPropertyValues);
        beanFactory.registerBeanDefinition("aPerson", personBeanDefinition);

        Person person = (Person) beanFactory.getBean("aPerson");
        assertThat(person).isNotNull();
        assertThat(person.getName()).isEqualTo("zhang3");
        assertThat(person.getAge()).isEqualTo(19);
        Car car = person.getCar();
        assertThat(car).isNotNull();
        assertThat(car.getBrand()).isEqualTo("porsche");
        System.out.println(person);
    }
}
