package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/7/20 11:15
 * @description //918. 环形子数组的最大和
 */
public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
