package com.tw.minispring.ioc;

import com.tw.minispring.bean.Person;
import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 6:58 下午
 */
public class AutowiredAnnotationTest {

    @Test
    public void testAutowiredAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:autowired-annotation.xml");
        Person person = applicationContext.getBean(Person.class);
        assertThat(person.getCar()).isNotNull();
        System.out.println(person);
    }
}
