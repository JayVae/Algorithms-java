package com.xjtu.ch2;

import java.util.Random;

/**
 * @Author: Jay
 * @Date: Created in 9:09 2018/5/21
 * @Modified By:
 */
public class ShellSort extends BaseSort{

    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h<N/3) h=3*h+1;
        while (h>=1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j],a[j-h]) ; j-=h) {
                    exch(a,j,j-h);
                }
            }
            h = h/3;
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
