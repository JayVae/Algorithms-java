package coom.xjtu.ch2;

import java.util.Random;

/**
 * @Author: Jay
 * @Date: Created in 16:15 2018/5/18
 * @Modified By:
 */
public abstract class BaseSort{

    public static void sort(Comparable[] a){

    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    public static void exch(Comparable[] a , int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void shuffle(Comparable[] a) {
        if (a==null)
            throw new IllegalArgumentException("空");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + new Random().nextInt(n-i);     // between i and n-1
            Comparable temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

}
