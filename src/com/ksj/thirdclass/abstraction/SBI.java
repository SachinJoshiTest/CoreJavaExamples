package com.ksj.thirdclass.abstraction;

public class SBI implements BankInterface{
    @Override
    public double rateOfInterest() {
        return 6.0;
    }

    @Override
    public int noOfBranches() {
        return 15502;
    }

    @Override
    public double rateOfInterestHomeLoan() {
        return 6.9;
    }
}
