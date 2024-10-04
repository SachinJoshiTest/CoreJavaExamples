package com.ksj.fourthclass.customException;

public class CustomExceptionExample {
    public static void main(String[] args) {

        VoterCheck voterCheck = new VoterCheck();
        try {
            voterCheck.checkVoterEligibility(15);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
