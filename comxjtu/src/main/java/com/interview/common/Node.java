package com.interview.common;

public class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printLinkedList(Node node){
        while(node != null){
            System.out.print(node.getValue());
            System.out.print(" ");
            node = node.getNext();
        }
        System.out.println();
    }
}
