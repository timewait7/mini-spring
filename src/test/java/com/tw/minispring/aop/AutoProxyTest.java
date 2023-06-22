package com.tw.minispring.aop;

import com.tw.minispring.context.support.ClassPathXmlApplicationContext;
import com.tw.minispring.service.WorldService;
import org.junit.Test;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 2:49 下午
 */
public class AutoProxyTest {

    @Test
    public void testAutoProxy() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");
        WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
        worldService.explode();
    }
}
