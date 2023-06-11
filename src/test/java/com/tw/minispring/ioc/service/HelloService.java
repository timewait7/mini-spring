package com.tw.minispring.ioc.service;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 9:33 上午
 */
public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}