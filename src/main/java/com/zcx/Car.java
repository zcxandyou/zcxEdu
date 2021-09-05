package com.zcx;

public class Car {
    public String brand = "bwm";
    public int price = 5000000;
    public String color = "white";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
