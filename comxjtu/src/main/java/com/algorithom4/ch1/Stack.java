package com.algorithom4.ch1;

/**
 * @Author: Jay
 * @Date: Created in 14:55 2018/5/16
 * @Modified By:
 */

import java.util.Iterator;

/**
 * 链表实现栈
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public boolean isEmpty(){

        return first == null;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current!=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
