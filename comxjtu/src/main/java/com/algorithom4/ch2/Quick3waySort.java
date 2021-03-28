package com.algorithom4.ch2;

/**
 * @Author: Jay
 * @Date: Created in 10:55 2018/5/21
 * @Modified By:
 */
public class Quick3waySort extends BaseSort{

    public static void sort(Comparable[] a){
        shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo, i=lo+1,gt=hi;
        Comparable v = a[lo];
        while (i<=gt){
            int cmp = a[i].compareTo(v);
            if (cmp<0) exch(a,lt++,i++);
            else if (cmp>0) exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
}
