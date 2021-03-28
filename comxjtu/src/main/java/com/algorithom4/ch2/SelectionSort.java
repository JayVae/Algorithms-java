package com.algorithom4.ch2;

import java.util.Random;

/**
 * @Author: Jay
 * @Date: Created in 8:13 2018/5/21
 * @Modified By:
 */
public class SelectionSort extends BaseSort {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j],a[min])) min = j;
            }
            exch(a,i,min);
        }
    }

    public static void main(String[] args){
        Integer[] a= new Integer[20];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(101);
        }
        assert isSorted(a);
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
