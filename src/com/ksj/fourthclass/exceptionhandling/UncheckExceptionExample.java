package com.ksj.fourthclass.exceptionhandling;

public class UncheckExceptionExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        //Unchecked exceptions like divide by zero, arrayIndexOutOfBound, NullPointerException, etc should never be caught
        if(b!=0) {
            System.out.println(a / b);
        } else {
            System.out.println("Cannot divide by zero");
        }
    }
}
