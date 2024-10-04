package com.ksj.fourthclass.customException;

public class VoterCheck {

    public void checkVoterEligibility(int age) throws InvalidAgeException {
        int minimumAgeForVoter = 18;

        if(age < minimumAgeForVoter){
            throw new InvalidAgeException("Person is not eligible to vote");
        }
        System.out.println("Person eligible to vote");
    }
}
