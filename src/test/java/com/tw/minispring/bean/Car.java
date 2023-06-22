package com.tw.minispring.bean;

import com.tw.minispring.beans.factory.annotation.Value;
import com.tw.minispring.stereotype.Component;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 4:15 下午
 */
@Component
public class Car {

    @Value("${brand}")
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
