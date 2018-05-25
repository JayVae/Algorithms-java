package com.leetcode.base;

/**
 * @Author: Jay
 * @Date: Created in 17:02 2018/5/25
 * @Modified By:
 */
public class InverseArray {
    /**
     * 将数组逆序排列
     * @param arr
     */
    public int[] inverseArr(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len/2; i++) {
            int tmp = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = tmp;
        }
        return arr;
    }

}
