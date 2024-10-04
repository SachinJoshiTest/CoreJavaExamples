package com.ksj.thirdclass.inheritance;

public class Car {
    private int id;
    private String name;
    private double price;
    public double carSpeed;

    public void accelarate() {
        carSpeed = carSpeed * 1.5;
    }
}
