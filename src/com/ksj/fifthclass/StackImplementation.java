package com.ksj.fifthclass;

public class StackImplementation {
    int top;
    int arr[];
    int capacity;


    StackImplementation(int capacity){
        arr = new int[capacity];
        top=-1;
        this.capacity = capacity;

    }

    public void push(int element){
        if(top<capacity-1){
            arr[++top] = element;
            System.out.println("Element " + element + " added succcessfully");
        } else{
            System.out.println("Stack Overflow");
        }
    }

    public int pop() {
        if(top == -1 ){
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return arr[top--];
        }
    }

    public static void main(String[] args) {
        StackImplementation a = new StackImplementation(3);
        StackImplementation b = new StackImplementation(3);
        StackImplementation c = new StackImplementation(3);

        a.push(65);
        a.push(56);
        a.push(45);

        b.push(a.pop());
        b.push(a.pop());

        c.push(a.pop());
        c.push(b.pop());
        c.push(b.pop());

        System.out.println(c.pop());
        System.out.println(c.pop());
        System.out.println(c.pop());

    }

}
