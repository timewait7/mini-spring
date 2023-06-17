package com.tw.minispring.ioc.service;

import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 6:45 下午
 */
public class InitAndDestroyMethodTest {

    @Test
    public void testInitAndDestroyMethod() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-destroy.xml");
        applicationContext.registerShutdownHook();
    }
}
