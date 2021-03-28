package com.algorithom4.ch2;

import java.util.Random;

/**
 * @Author: Jay
 * @Date: Created in 8:51 2018/5/21
 * @Modified By:
 */
public class InsertSort extends BaseSort{

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]); j--) {
                exch(a,j,j-1);
            }
        }
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Integer[] a= new Integer[500];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(5000);
        }
        assert isSorted(a);
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }
}
