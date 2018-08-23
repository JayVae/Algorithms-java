package com.xjtu.ch1;

/**
 * @Author: Jay
 * @Date: Created in 20:08 2018/5/21
 * @Modified By:
 */
public class BinarySearch {

/**
 * 见BST,见ThreeSumFast
 */
    public int binarySearch(int[] a,int t){
        int lo = 0, hi = a.length-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (a[mid]>t) hi = mid - 1;
            else if (a[mid]<t) hi = mid +1;
            else  return mid;
        }
        return -1;
    }

    public int binarySearchRank(int[] a,int t){
        int lo = 0, hi = a.length-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (a[mid]>t) hi = mid - 1;
            else if (a[mid]<t) hi = mid +1;
            else  return mid;
        }
        return lo;
    }
}
