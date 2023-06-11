package com.tw.minispring.ioc.bean;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 4:15 下午
 */
public class Car {

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
