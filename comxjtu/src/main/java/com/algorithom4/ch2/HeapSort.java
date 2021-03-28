package com.algorithom4.ch2;

/**
 * @Author: Jay
 * @Date: Created in 15:04 2018/5/21
 * @Modified By:
 */

/**
 * 堆排序：按照降序
 *  1.构造堆:从子堆开始构造
 *  2.堆下沉
 */
public class HeapSort {

    public static void sort(Comparable[] pq) {
        int n = pq.length;
//        构造堆
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
//        堆下沉，逐个弹出最大的
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

}
