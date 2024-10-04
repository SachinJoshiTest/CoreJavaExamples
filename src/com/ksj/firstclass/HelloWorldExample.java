//Package declaration comes here
package com.ksj.firstclass;

//Public class which will have the main method, This should match with the file Name
public class HelloWorldExample {
    //Instance variables will come here
    private int test;
    private static int test2; // test2 is static and hence only a single instance will be shared throughout the program

    static {
        System.out.println("This is static block gets executed before main method");
    }

    //This is the driver method, Code execution starts from here
    public static void main(String[] args) {
        System.out.println("Hello World, This is first Java program");

        // We cannot use test variable here because it is non static, non static variable or methods cannot be called from static context
        //Uncomment the code below to see if its true
        //System.out.println("Trying to print value of test " + test);

        //But we can access static variables directly
        System.out.println(" Value of test2 is "+ test2);

        //Even if two different objects change the value of test2 both the objects will contain same value but that is not the case in test

        //This is how we create object where after new keyword we have the default constructor
        HelloWorldExample object1 = new HelloWorldExample();
        HelloWorldExample object2 = new HelloWorldExample();

        object1.test = 10;
        object2.test = 20;

        object1.test2 = 40;
        object2.test2 = 50;

        //Will get different values since the test variable is not static
        System.out.println("Different values coz non static" + object1.test + " " + object2.test);

        //Will get the last updated value that is 50 for both objects because the variable is declared static
        System.out.println("Same values coz static" + object1.test2 + " " + object2.test2);

        //We can also call the static variable directly using the class name also
        System.out.println("Calling static variable with Classname" + HelloWorldExample.test2);

        //Also since test2 is part of this class only we can also call directly cause we are in main method which is also static
        System.out.println("Using variable directly in static method main "+ test2);

        //Calling increment method using object1 and printing using object2 but getting incremented value cause it is tatic
        object1.incrementTest();
        System.out.println("Test2 value after increment " + object2.test2);

    }

    public void incrementTest() {
        test2++;
    }
}
