package com.ksj.sixthclass.binarytree;

import java.util.ArrayList;
import java.util.List;


public class ImplementBinaryTree {
    Node root;
    List<Integer> inOrder = new ArrayList<Integer>();
    List<Integer> preOrder = new ArrayList<>();
    List<Integer> postOrder = new ArrayList<>();


    public void insert(int value) {
        if(root == null) {
            root = new Node(value);
        } else {
            insertRecursively(root,value);
        }
    }

    public Node insertRecursively(Node node, int value) {
        if(node == null) {
            return new Node(value);
        }
        if(value<node.value) {
            node.left = insertRecursively(node.left, value);
        } else if(value>node.value) {
            node.right = insertRecursively(node.right,value);
        }
        return node;
    }

    public List<Integer> traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            inOrder.add(node.value);
            traverseInOrder(node.right);
        }
        return inOrder;
    }

    public List<Integer> traversePreOrder(Node node) {
        if (node != null) {
            preOrder.add(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
        return preOrder;
    }

    public List<Integer> traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            postOrder.add(node.value);
        }
        return postOrder;
    }

    public List<Integer> traverseOnlyLeft(Node node) {
        if (node != null) {
            if(node.left!=null) {
                inOrder.add(node.left.value);

            }
            traverseInOrder(node.left);

            traverseInOrder(node.right);

        }
        return inOrder;
    }

    public void invertBinaryTree(Node node) {
        if(node !=null) {
            swap(node);
            invertBinaryTree(node.left);
            invertBinaryTree(node.right);
        }
    }

    public void swap(Node n) {
        Node temp = n.left;
        n.left = n.right;
        n.right = temp;
    }


    public static void main(String args[]) {
        ImplementBinaryTree binaryTree = new ImplementBinaryTree();
        binaryTree.insert(50);
        //binaryTree.root = new Node(65);
        binaryTree.insert(55);
        binaryTree.insert(87);
        binaryTree.insert(90);
        binaryTree.insert(11);
        binaryTree.insert(43);
        binaryTree.insert(13);
        binaryTree.insert(100);
        binaryTree.insert(4);




        List<Integer> inOrder = binaryTree.traverseInOrder(binaryTree.root);
        System.out.println("Inorder : " + inOrder);

        List<Integer> preOrder = binaryTree.traversePreOrder(binaryTree.root);
        System.out.println("Preorder : " + preOrder);

        List<Integer> postOrder = binaryTree.traversePostOrder(binaryTree.root);
        System.out.println("Postorder : " + postOrder);

        binaryTree.invertBinaryTree(binaryTree.root);

        binaryTree.inOrder = new ArrayList<>();
        List<Integer> inOrderInvert = binaryTree.traverseInOrder(binaryTree.root);
        System.out.println("Inorder : " + inOrderInvert);

    }

}
