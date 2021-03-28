package com.algorithom4.ch1;

import java.util.Iterator;

/**
 * @Author: Jay
 * @Date: Created in 10:59 2018/5/16
 * @Modified By:
 */

/**
 * 用数组实现长度可调的栈
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{

    private int N=0;
    private Item[] a = (Item[]) new Object[1];

    public ResizingArrayStack() {
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        if(N==a.length) resize(2*a.length);
        a[N++]=item;
    }

    public Item pop(){
//        没有判断N是否为0
        if(N==0){
            System.out.println("没有了");
            return null;
        }
        Item item = a[--N];
//        避免对象游离
        a[N]=null;
        if(N>0 && N==a.length/4)
            resize(a.length/2);
        return item;
    }

    public boolean isEmpty(){

        return N==0;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a=temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public static void main(String[] args){
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        s.push("a");
        System.out.println(s.size());
        s.push("b");
        System.out.println(s.size());
        s.push("c");
        System.out.println(s.size());
        s.pop();
        System.out.println(s.size());
        s.pop();
        System.out.println(s.size());
        s.pop();
        System.out.println(s.size());
        s.pop();
        System.out.println(s.size());
    }
}
