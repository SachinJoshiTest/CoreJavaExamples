package com.ksj.fourthclass.customException;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(String message) {
        super(message);
    }
}
