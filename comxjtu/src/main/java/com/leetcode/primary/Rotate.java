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

        int n=matrix[0].length-1;
        for(int i=0;i<=n/2;i++){//需要交换位子的层数  i是交换该层的左边界 n-1-i是右边界
            for(int j=0;j<(n+1)/2;j++){//每次点交换lenght-1次
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j][i];
                matrix[n-j][i]= matrix[n-i][n-j];
                matrix[n-i][n-j]=matrix[j][n-i];
                matrix[j][n-i]=temp;
            }

        }
    }

    /**
     * 通过实际数据分析，通过两个步骤的元素交换可实现目标：
     1.按照副主对角线，将对称元素交换
     2.按照行，将对称列元素全部交换
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        if (matrix == null)
            return;
        int n = matrix.length;
        // 沿着副对角线旋转
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        // 沿着中间水平线旋转
        for (int i = 0; i < n / 2; i++)
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
    }

    /**
     * 从外到内一圈一圈的转，但这个方法太慢。
     * @param matrix
     */
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int start = layer;
            int end = n - 1 - start;
            for (int i = start; i < end; i++) {
                int offset = i - start;
                int temp = matrix[start][i];
                // left to top;
                matrix[start][i] = matrix[end - offset][start];
                // bottom to left;
                matrix[end - offset][start] = matrix[end][end - offset];
                // right to bottm;
                matrix[end][end - offset] = matrix[i][end];
                // top to right;
                matrix[i][end] = temp;
            }
        }
    }
}
