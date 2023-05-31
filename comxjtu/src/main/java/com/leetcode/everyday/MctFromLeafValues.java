package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/31 10:40
 * @description //1130. 叶值的最小代价生成树
 * 这个问题竟然是区间dp，区间dp各个区间的有效性是如何保证的？
 */
public class MctFromLeafValues {

    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 4);
            }
            int[][] mval = new int[n][n];
            for (int j = 0; j < n; j++) {
                mval[j][j] = arr[j];
                dp[j][j] = 0;
                for (int i = j - 1; i >= 0; i--) {
                    mval[i][j] = Math.max(arr[i], mval[i + 1][j]);
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + mval[i][k] * mval[k + 1][j]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
