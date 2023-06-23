package com.tw.minispring.bean;

import com.tw.minispring.beans.factory.annotation.Value;
import com.tw.minispring.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 4:15 下午
 */
@Component
public class Car {

    private int price;

    private LocalDate producedDate;

    @Value("${brand}")
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(LocalDate producedDate) {
        this.producedDate = producedDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", producedDate=" + producedDate +
                ", brand='" + brand + '\'' +
                '}';
    }
}
