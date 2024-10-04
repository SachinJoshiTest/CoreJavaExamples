package com.ksj.fifthclass;

public class QueueImplementation {
    int array[];
    int front;
    int rear;
    int capacity;
    int waitingInQueue;

    QueueImplementation(int size) {
        array = new int[size];
        front=0;
        rear=-1;
        capacity = size;
        waitingInQueue = 0;
    }

    public void enQueue(int element) {
        if(waitingInQueue == capacity) {
            System.out.println("Queue is full");
        } else {
            rear = (rear + 1) % capacity;
            array[rear] = element;
            waitingInQueue++;
        }
    }

    public int deQueue() {
        if(waitingInQueue == 0) {
            System.out.println("Waiting list empty");
            return -1;
        } else {
            int serving = array[front];
            System.out.println("Serving " + serving);
            front = (front + 1) % capacity;
            waitingInQueue--;
            return serving;
        }
    }

    public void peek() {
        if(waitingInQueue>0) {
            System.out.println("Customer in front is " + array[front]);
        }
    }

    public static void main(String args[]) {
        QueueImplementation queue = new QueueImplementation(5);
        queue.enQueue(45);
        queue.enQueue(69);
        queue.peek();
        queue.enQueue(88);
        queue.deQueue();
        queue.peek();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.peek();
    }
}
