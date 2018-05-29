package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 14:11 2018/5/29
 * @Modified By:
 */
public class Rotate {
    /**
     * 这个是旋转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int N=nums.length;
        if (k<=0 || nums==null || N==1 || N==0 || k%N==0) return;
        int n = k%N;
        for (int i = 0; i < n; i++) {
            int last = nums[N-1];
            for (int j = N-1; j >0; j--) {
                nums[j]=nums[j-1];
            }
            nums[0]=last;
        }
//        System.out.print("[");
//        for (int i = 0; i < N; i++) {
//            System.out.print(nums[i]+" ");
//        }
//        System.out.println("]");
    }

    /**
     * 这个是旋转图片（二维数组）
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix.length!=matrix[0].length) return;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            int[] tmp = new int[len];
            tmp = matrix[0];

            matrix[1]=matrix[0];
        }
    }
}
