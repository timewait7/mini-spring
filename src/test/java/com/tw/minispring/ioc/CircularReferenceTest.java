package com.tw.minispring.ioc;

import com.tw.minispring.bean.A;
import com.tw.minispring.bean.B;
import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 5:17 下午
 */
public class CircularReferenceTest {

    @Test
    public void testCircularReferenceWithoutProxyBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-without-proxy-bean.xml");
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);
        assertThat(a.getB() == b).isTrue();
    }

    @Test
    public void testCircularReferenceWithProxyBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-with-proxy-bean.xml");
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);

        assertThat(b.getA() != a).isTrue();
    }
}
