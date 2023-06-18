package com.tw.minispring.ioc.common;

import com.tw.minispring.beans.factory.xml.FactoryBean;
import com.tw.minispring.ioc.bean.Car;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 11:06 上午
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(brand);
        return car;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
