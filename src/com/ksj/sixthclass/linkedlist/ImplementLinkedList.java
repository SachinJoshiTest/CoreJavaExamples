package com.ksj.sixthclass.linkedlist;


public class ImplementLinkedList {
    Node head;

    public void insert(int value) {
        Node nodeToInsert = new Node(value);
        if (this.head == null) {
            head = nodeToInsert;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = nodeToInsert;
        }
    }

    public void insertAfter(int insertAfterNode, int value) {
        Node nodeToInsert = new Node(value);
        Node n = this.head;
        while (n.next != null) {
            if (n.value == insertAfterNode) {
                Node temp = n.next;
                n.next = nodeToInsert;
                nodeToInsert.next = temp;
            }
            n = n.next;
        }
    }

    public void delete(int val) {
        Node prev = head;
        Node curr = head;
        if (head.value == val) {
            head = head.next;
        } else {
            while (curr != null) {
                if (curr.value == val) {
                    prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            System.out.printf("Key %s not found\n", val);

        }
    }

    public void printList() {
        Node n = this.head;
        while (n.next != null) {
            System.out.print(n.value + "-> ");
            n = n.next;
        }
        System.out.println(n.value);
    }

    public static void main(String args[]) {
        ImplementLinkedList list = new ImplementLinkedList();
        list.insert(10);
        list.insert(56);
        list.insert(22);
        list.printList();

        list.insertAfter(56, 112);
        list.printList();

        list.insertAfter(10, 45);
        list.printList();

        //Deleting head
        list.delete(10);
        list.printList();

        //Deleting value in between
        list.delete(112);
        list.printList();

        //Trying to delete value not present in the list
        list.delete(555);
        list.printList();

        list.delete(22);
        list.printList();
    }
}
