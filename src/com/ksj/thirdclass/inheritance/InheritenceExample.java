package com.ksj.thirdclass.inheritance;

public class InheritenceExample {
    public static void main(String[] args) {

        //Assigning Child class Object to Parent class reference allowed
        Car car = new Mercedes();
        car.carSpeed = 45;

        //Assigning Parent class object to child class reference Not allowed, uncomment and see for yourself
        //Mercedes m = new Car();
        System.out.println("Speed of Mercedes before accelaration " + car.carSpeed);
        //Method Overriding happening here, instead of increasing the speed by 1.5 time speed will be increated by 2 times
        car.accelarate();
        System.out.println("Speed of Mercedes after accelaration " + car.carSpeed);


        //But if i use car object only the accelrate method will not be overridden

        Car car2 = new Maruti();
        car2.carSpeed = 30;

        System.out.println("Speed of Maruti before accelaration " + car2.carSpeed);
        //Method Overriding not happening here, car speed increased by 1.5 times
        car2.accelarate();
        System.out.println("Speed of Maruti after accelaration " + car2.carSpeed);
    }
}
