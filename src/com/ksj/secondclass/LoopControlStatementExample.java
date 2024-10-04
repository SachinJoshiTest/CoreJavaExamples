package com.ksj.secondclass;

public class LoopControlStatementExample {
    public static void main(String[] args) {
        forLoopExample();
        whileLoopExample();
        doWhileExample();
        forEachExample();
    }

    public static void forLoopExample() {
        /*
        Lets print this pattern using for Loop

        * * * * *
        * * * *
        * * *
        * *
        *

        If we see we have 5 rows printed and in each subsequent row the number of stars are reduced by 1
        so that is our logic4
        We will have two for loops first loop or outer loop to control the number of rows
        and inner loop to control number of stars in each row
         */

        System.out.println("Print the pattern");
        for(int i=5; i>0 ; i--) {
            for (int j= 0; j<i ; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

    }

    public static void whileLoopExample() {

        // Printing table of any number
        System.out.println("Print table of 67");
        int number=67;
        int tableCounter = 1;
        while (tableCounter<=10) {
            System.out.println(number + " * " + tableCounter + " = " + number * tableCounter);
            tableCounter++;
        }

    }

    public static void doWhileExample() {
        // Printing first n odd numbers
        System.out.println("Printing odd numbers");
        int n = 5;
        int countOfOddNumbersPrinted = 0;
        int i = 0;
        do {
            if(i%2 != 0) {
                System.out.println(i);
                countOfOddNumbersPrinted++;
            }
            i++;
        } while(countOfOddNumbersPrinted<n);
    }

    public static void forEachExample() {
        System.out.println("For Each example which can be used to iterate over any collection or array");
        String name = "Sachin";
        for (char character: name.toCharArray()) {
            System.out.println(character);
        }

    }
}
