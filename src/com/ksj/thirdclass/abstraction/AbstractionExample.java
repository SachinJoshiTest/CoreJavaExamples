package com.ksj.thirdclass.abstraction;

public class AbstractionExample {
    public static void main(String[] args) {
        BankInterface sbiBank = new SBI();
        System.out.println(sbiBank.rateOfInterest());

        BankInterface kotakBank = new Kotak();
        System.out.println(kotakBank.rateOfInterestHomeLoan());
    }
}
