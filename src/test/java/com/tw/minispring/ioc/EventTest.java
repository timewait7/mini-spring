package com.tw.minispring.ioc;

import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import com.tw.minispring.common.event.CustomEvent;
import org.junit.jupiter.api.Test;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 1:46 下午
 */
public class EventTest {

    @Test
    public void testEventListener() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext));
        applicationContext.registerShutdownHook();
    }
}
