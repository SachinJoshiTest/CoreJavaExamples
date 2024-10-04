package com.ksj.thirdclass.overloading;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Adding two int " + calc.add(5,3));
        System.out.println("Adding 3 int " + calc.add(7, 9,3));
        System.out.println("Adding two double values " + calc.add(11.2,3.9));


    }

    public int add(int a, int b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c;
    }

    public int add(double a, double b) {
        return new Double(a + b).intValue();
    }
}
