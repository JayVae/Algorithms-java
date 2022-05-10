package com.leetcode.Question.hard;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/9 17:47
 * @description //TODO
 */
public class lc4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0 && nums2.length==0) return 0;
        int i=0,  j=0, len=nums1.length+nums2.length;
        //len为偶数，则中位数是(len-1)/2与(len-1)/2+1的平均值；奇数：(len-1)/2
        while (i+j<(len-1)/2){
            if (i==nums1.length){
                int left = (len-1)/2-nums1.length;
                if (len%2==1){
                    return nums2[left];
                }else {
                    if (left==0){
                        return (double) (nums1[nums1.length-1]+nums2[j])/2;
                    }else {
                        return (double) (nums2[left]+nums2[left+1])/2;
                    }
                }
            }
            if (j==nums2.length){
                int left = (len-1)/2-nums2.length;
                if (len%2==1){
                    return nums1[left];
                }else {
                    if (left==0){
                        return (double) (nums2[nums2.length-1]+nums1[i])/2;
                    }else {
                        return (double) (nums1[left]+nums1[left+1])/2;
                    }
                }
            }
            if (nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        return 0;
    }
}
