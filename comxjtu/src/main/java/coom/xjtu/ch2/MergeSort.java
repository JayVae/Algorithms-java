package coom.xjtu.ch2;

import java.util.Random;

/**
 * @Author: Jay
 * @Date: Created in 10:09 2018/5/21
 * @Modified By:
 */
/*
自顶向下
 */
public class MergeSort extends BaseSort{

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo, int hi){
        if (hi<=lo) return;
        int mid = lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo,j=mid+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i>mid) a[k] = aux[j++];
            else if (j>hi) a[k]=aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k]=aux[i++];
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
