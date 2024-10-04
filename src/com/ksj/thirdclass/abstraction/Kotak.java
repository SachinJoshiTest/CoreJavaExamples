package com.ksj.thirdclass.abstraction;

public class Kotak extends AbstractClass implements BankInterface{
    @Override
    public void doSomething() {
        System.out.println("Some Implementation");
    }

    @Override
    public double rateOfInterest() {
        return 0;
    }

    @Override
    public int noOfBranches() {
        return 0;
    }

    @Override
    public double rateOfInterestHomeLoan() {
        return 0;
    }
}
