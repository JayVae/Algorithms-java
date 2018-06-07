package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 19:53 2018/6/6
 * @Modified By:
 */
public class MinStack {
    /** initialize your data structure here. */
    Node first;
    Node min;
    public MinStack() {

    }

    public void push(int x) {
        if (first==null){
            first = new Node(x);
            min = new Node(x);
        }else {
            Node oldfirst = first;
            first = new Node(x);
            first.next = oldfirst;
            if (x<min.val){
                Node oldmin = min;
                min = new Node(x);
                min.next = oldmin;
            }else {
                Node oldmin = min;
                min = new Node(oldmin.val);
                min.next = oldmin;
            }
        }

    }

    public void pop() {
        first = first.next;
        min = min.next;
    }

    public int top() {
        return first.val;
    }

    public int getMin() {
        return min.val;
    }

    public class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
