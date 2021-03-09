package interview.loop;

import interview.common.Node;
import interview.recursion.LinkedListCreator;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListDelete {

    public Node deleteIfEquals(Node head, int value){

        //特殊情况：第一个节点是要删除的节点
        while (head != null && head.getValue() == value){
            head = head.getNext();
        }
        if (head == null){
            return head;
        }
        Node prev = head;

        while (prev.getNext() != null){
             if (prev.getNext().getValue() == value){
                 prev.setNext(prev.getNext().getNext());
             }else {
                 prev = prev.getNext();
             }
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedListDelete linkedListDelete = new LinkedListDelete();

        Node.printLinkedList(linkedListDelete.deleteIfEquals(linkedListCreator.createLinkedList(new ArrayList<>()),1));
        Node.printLinkedList(linkedListDelete.deleteIfEquals(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,2,5)),2));
        Node.printLinkedList(linkedListDelete.deleteIfEquals(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,2,2)),2));
        Node.printLinkedList(linkedListDelete.deleteIfEquals(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,2,5)),1));
        Node.printLinkedList(linkedListDelete.deleteIfEquals(linkedListCreator.createLinkedList(Arrays.asList(1,1,1,2,3,2,5)),1));
        Node.printLinkedList(linkedListDelete.deleteIfEquals(linkedListCreator.createLinkedList(Arrays.asList(1,1,1)),1));
        Node.printLinkedList(linkedListDelete.deleteIfEquals(linkedListCreator.createLinkedList(Arrays.asList(1,1,1)),2));
    }
}
