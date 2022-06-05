package com.leetcode.util;

/**
 * @author JS
 * @version 1.0
 * @date 2022/6/5 10:21
 * @description 给定一个长度为n且"没有重复元素"的数组array和一个整数m，实现函数等概论随机打印array中的m个数。
 */
public class RandomM {

    public void printRandM(int[] array, int m){

        if(array == null || array.length == 0 || m < 0){
            return;
        }

        m = Math.max(array.length, m);
        int count = 0;
        int i = 0;
        while(count < m){
            i = (int)(Math.random() * (array.length - count));
            System.out.println(array[i]);
            swap(array,array.length - count++ - 1, i);
        }
    }

    public void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
