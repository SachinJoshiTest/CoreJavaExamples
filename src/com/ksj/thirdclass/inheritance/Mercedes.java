package com.ksj.thirdclass.inheritance;

public class Mercedes extends Car{
    private boolean isSportsCar;
    private String connectivityOption[];
    private String parkingSensorBrand;

    @Override
    public void accelarate() {
        carSpeed = carSpeed * 2;
    }

}
