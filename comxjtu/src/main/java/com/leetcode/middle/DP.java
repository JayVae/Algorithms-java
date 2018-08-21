package com.leetcode.middle;

import java.util.Arrays;

/**
 * @Author: Jay
 * @Date: Created in 17:50 2018/6/9
 * @Modified By:
 */
public class DP {

    public boolean canJump(int[] nums) {
        if (nums.length<2) return true;
        int n = nums.length-1;
        while(n>0){
            boolean flag = false;
            int max=0;
            for (int i = n-1; i >=0; i--) {
                if (i==0){
                    if (n-i<=nums[i]){
                        flag = true;
                        max = i;
                    }
                }else if (n-i<=nums[i]){
                    flag = true;
                    max = i;
                }
            }
            if (flag){
                n=max;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     1
     其实就是个高中的组合数学的问题。
     　　m*n的棋盘，一共需要走(m-1)+(n-1)步，向右走m-1步，向下走n-1步，这(m-1)+(n-1)步中，只要确定了哪些步向右，即同时确定了哪些步向下走，反之亦然。
     　　答案即C(m+n-2,m-1)或C(m+n-2,n-1)
     2
     采用动态规划。
     对于格点(i,j)。由于只能从上格点(i-1,j)或左格点(i,j-1)到达，并且两者路径是不重复的
     因此path[i][j] = path[i-1][j]+path[i][j-1]

     int[][] ways = new int[m][n];
     for (int i = 0; i < m; i++) {
     for (int j = 0; j < n; j++) {
     if (i == 0 || j == 0) ways[i][j] = 1;
     else ways[i][j] = ways[i-1][j] + ways[i][j-1];
     }
     }
     return ways[m-1][n-1];

     **/
    public int uniquePaths(int m, int n) {
        double res = 1;
        for (int i = 1; i <= n - 1; i++)
            res *= ((double) (m + i - 1) / (double) i);
        return (int) Math.round(res);

    }

    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        for (int i = 1;i<=amount;i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 0;i<coins.length;i++){
            for (int j = coins[i];j<=amount;j++)
                if (dp[j-coins[i]]!=Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
//            System.out.println(Arrays.toString(dp));
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    /**
     * Longest Increasing Subsequence:给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * 动态规划方法的复杂度是O(N2)
     * https://blog.csdn.net/u013178472/article/details/54926531使用二分查找将复杂度降低到O(NlogN)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

    /**
     * lc343 拆分为至少两个正整数
     * 第一个方法是记忆化搜索，自上而下
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n==1) return 1;
        int res = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=-1;
        }
        res = intbreak(n,dp);
        return res;
    }
    private int intbreak(int n, int[] dp){
        if (n==1){
            dp[0]=1;
            return 1;
        }
        if (dp[n-1]!=-1) return dp[n-1];
        for (int i = 1; i < n; i++) {
            dp[n-1] = max3(dp[n-1],intbreak(n-i,dp)*i,i*(n-i));
        }
        return dp[n-1];
    }
    private int max3(int a, int b, int c){
        return Math.max(a,Math.max(b,c));
    }
    public int integerBreak2(int n) {
        if (n<=1) return 1;
        int res = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=-1;
        }
        dp[0]=1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i-1] = max3(dp[i-1],dp[i-1-j]*j,(i-j)*j);
            }
        }
        return dp[n-1];
    }
}

