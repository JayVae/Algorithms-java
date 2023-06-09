package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/31 10:40
 * @description //1130. 叶值的最小代价生成树
 * 这个问题竟然是区间dp，区间dp各个区间的有效性是如何保证的？
 * 设dp[i][j]表示从i到j这段区间中所有非叶节点的最小可能总和。然后对于每个区间[i,j]，我们可以枚举最后一步的操作，
 * 即把区间[i,j]分成两个子区间[l,k]和[k+1,r]，使得[l,k]和[k+1,r]分别是其中一个非叶节点的左子树和右子树。
 * 那么非叶节点的值就是max{arr[p]}, l <= p <= k和l <= p <= r-k。
 * 我们可以用一个变量maxNum记录[p,k]和[k+1,r]中的最大值，然后再把左右子树的dp值相乘，加上这个maxNum，就可以得到区间[i,j]中所有非叶节点的最小值。
 * 由于我们需要对所有的区间[i,j]进行计算，所以可以使用二维数组dp来保存每个区间的结果，最后返回dp[0][n-1]即可。
 */
public class MctFromLeafValues {

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int maxNumL = Arrays.stream(arr, i, k+1).max().orElse(0);
                    int maxNumR = Arrays.stream(arr, k+1, j+1).max().orElse(0);
                    int nonLeafVal = maxNumL * maxNumR;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + nonLeafVal);
                }
            }
        }
        return dp[0][n-1];
    }
}
