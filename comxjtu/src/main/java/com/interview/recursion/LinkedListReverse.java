package com.interview.recursion;

import com.interview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListReverse {

    /**
     * 递归方法
     * @param head
     * @return
     */
    public Node reverseLinkedList(Node head){
        // size == 0
        if (head == null){
            return null;
        }
        // size == 1
        if (head.getNext() == null){
            return head;
        }

        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    /**
     * 循环方法
     * @param head
     * @return
     */
    public Node reverseLinkedList2(Node head){
        //定义循环不变式中的变量
        Node newHead = null;
        Node currHead = head;
        //循环不变式:newHead 指向已经反转的节点 currHead 指向还未反转的节点
        //
        while(currHead != null){
            Node next = currHead.getNext();
            currHead.setNext(newHead);
            newHead = currHead;
            currHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {

        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedListReverse linkedListReverse = new LinkedListReverse();

        Node.printLinkedList(linkedListReverse.reverseLinkedList2(linkedListCreator.createLinkedList2(new ArrayList<>())));
        Node.printLinkedList(linkedListReverse.reverseLinkedList2(linkedListCreator.createLinkedList2(Arrays.asList(1))));
        Node.printLinkedList(linkedListReverse.reverseLinkedList2(linkedListCreator.createLinkedList2(Arrays.asList(1,2,3,4,5))));
    }
}
