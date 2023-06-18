package com.tw.minispring.ioc;

import com.tw.minispring.beans.factory.support.DefaultListableBeanFactory;
import com.tw.minispring.beans.factory.xml.XmlBeanDefinitionReader;
import com.tw.minispring.bean.Car;
import com.tw.minispring.bean.Person;
import com.tw.minispring.common.CustomBeanFactoryPostProcessor;
import com.tw.minispring.common.CustomBeanPostProcessor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 2:09 下午
 */
public class PostProcessorTest {

    @Test
    public void testBeanFactoryPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 实例化bean之前，修改BeanDefinition的属性值
        CustomBeanFactoryPostProcessor beanFactoryPostProcessor = new CustomBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessorBeanFactory(beanFactory);

        Person person = (Person) beanFactory.getBean("person");
        assertThat(person.getName()).isEqualTo("ivy");
        System.out.println(person);
    }

    @Test
    public void testBeanPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 添加bean实例化后的处理器
        CustomBeanPostProcessor beanPostProcessor = new CustomBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        Car car = (Car) beanFactory.getBean("car");
        assertThat(car.getBrand()).isEqualTo("lamborghini");
        System.out.println(car);
    }
}
