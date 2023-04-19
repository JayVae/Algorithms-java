package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/19 15:46
 * @description //1043. 分隔数组以得到最大和
 */
public class MaxSumAfterPartitioning {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return d[n];
    }

    public static void main(String[] args) {
        int ans =0;
        MaxSumAfterPartitioning solver = new MaxSumAfterPartitioning();
        ans = solver.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3);
        System.out.println(ans);
        ans = solver.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4);
        System.out.println(ans);
        ans = solver.maxSumAfterPartitioning(new int[]{1}, 1);
        System.out.println(ans);
        ans = solver.maxSumAfterPartitioning(new int[]{1,2}, 3);
        System.out.println(ans);
    }
}
