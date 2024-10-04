package com.ksj.secondclass;

public class ConditionalStatement {
    public static void main(String[] args) {
        /*Checking grade of student based on marks
            <40 = Fail
            40-59 = Pass
            60-75 = FirstClass Pass
            >75 = Distinction
         */


        ifElse();
        switchExample();
    }

    private static void ifElse() {
        int marksOfStudent = 60;

        if(marksOfStudent<40){
            System.out.println("Fail");
        } else if(marksOfStudent>=40 && marksOfStudent<60) {
            System.out.println("Pass");
        } else if(marksOfStudent>=60 && marksOfStudent<75){
            System.out.println("First Class Pass");
        } else if(marksOfStudent>=75 && marksOfStudent<=100) {
            System.out.println("Distinction");
        } else {
            System.out.println("Invalid Marks");
        }
    }

    private static void switchExample() {
        String superHero = "Batman";

        switch (superHero) {
            case "Batman" :
                System.out.println("Intellect, fighting skills and am super rich");
                break;
            case "Superman" :
                System.out.println("I can fly");
                break;

            case "Flash" :
                System.out.println("Lightning fast speed");
                break;

            case "DrStrange" :
                System.out.println("I can control time");
                break;

            default:
                System.out.println("I am Thanos, Destroying world in 3, 2, .......");
        }
    }
}
