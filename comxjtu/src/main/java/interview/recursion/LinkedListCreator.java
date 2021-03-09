package interview.recursion;

import interview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCreator {
    /**
     * 新建链表
     *
     * @param data 新建的数据
     * @return
     */
    public Node createLinkedList(List<Integer> data){
        if (data.isEmpty()){
            return null;
        }
        Node firstNode = new Node(data.get(0));
        Node nextNode = createLinkedList(data.subList(1,data.size()));
        firstNode.setNext(nextNode);
        return firstNode;
    }

    public Node createLinkedList2(List<Integer> data){
        if (data.isEmpty()){
            return null;
        }
        Node first = new Node(data.get(0));
        first.setNext(null);
        Node thisNode = first;
        int j = 1;
        while (j < data.size()){
            Node nextNode = new Node(data.get(j));
            thisNode.setNext(nextNode);
            thisNode = thisNode.getNext();
            j++;
        }
        return first;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();

        Node.printLinkedList(linkedListCreator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,5,4)));

        System.out.println("-----------");

        Node.printLinkedList(linkedListCreator.createLinkedList2(new ArrayList<>()));
        Node.printLinkedList(linkedListCreator.createLinkedList2(Arrays.asList(1)));
        Node.printLinkedList(linkedListCreator.createLinkedList2(Arrays.asList(1,2,3,5,4)));
    }
}
