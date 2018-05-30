package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 21:51 2018/5/30
 * @Modified By:
 */
public class SortandSearch {
    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     说明:
     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1==null || nums2==null) return;
        if (n==0) return;

        if (m==0){
            for (int i = 0; i < n; i++) {
                nums1[i]=nums2[i];
            }
            return;
        }
        int[] nums1b = new int[m];
        for (int i = 0; i < m; i++) {
            nums1b[i] = nums1[i];
        }
        int k=0,j=0;
        for (int i = 0; i < m; ) {
            if (nums1b[i]<nums2[j]) {
                nums1[k]=nums1b[i];
                i++;
            }else {
                nums1[k]=nums2[j];
                j++;
            }
            k++;
            if (j==n){
                for (int l = i; l < m; l++) {
                    nums1[k]=nums1b[l];
                    k++;
                }
                break;
            }
        }
        for (int l = j; l < n; l++) {
            nums1[k] = nums2[l];
            k++;
        }
    }
}
