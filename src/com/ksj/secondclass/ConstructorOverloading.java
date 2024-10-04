package com.ksj.secondclass;

public class ConstructorOverloading {

    int a,b,c;

    ConstructorOverloading(){

    }

    ConstructorOverloading(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {

        //Using default Constructor
        ConstructorOverloading constructorOverloading = new ConstructorOverloading();

        //Using parameterised Constructor
        ConstructorOverloading constructorOverloading1 = new ConstructorOverloading(5,10,6);

        System.out.println(constructorOverloading1.a);

        System.out.println(constructorOverloading.a);

    }
}
