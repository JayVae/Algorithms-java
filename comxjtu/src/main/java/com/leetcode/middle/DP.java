package com.leetcode.middle;

import java.util.Arrays;

/**
 * @Author: Jay
 * @Date:
 * @Modified By:
 * @Description:  来源力扣中级算法之动态规划问题，https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvb8zs/
 */
public class DP {


    /**
     *
     * @Param
     * @Description //给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * way1:贪心：依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。
     * @Date 21:38 2022/4/29
     * @return
     **/
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @Param
     * @Description //way2:从后往前，用dp数组记录当前位置能否由最后到达。
     * @Date 22:41 2022/4/29
     * @return
     **/
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length];
        dp[length-1] = true;
        for (int i = length-1; i > 0; i--) {
            if (dp[i]){
                for (int j = 0; j < i; j++) {
                    if (dp[0]){
                        return true;
                    }
                    if (dp[j]){
                        continue;
                    }
                    if (nums[j]+j >= i){
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[0];
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


    /**
     * @Description 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * @Date 22:56 2022/4/29
     * @return
     **/
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
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

    
    /**
     * 
     * @Param 
     * @Description //1027. 最长等差数列
     * @Date 10:55 2023/4/22
     * @return 
     **/
    public int longestArithSeqLength(int[] nums) {
        // dp[i][d]表示以i为结尾的，公差为d的最长等差子序列的长度
        // 因为0 <= nums[i] <= 500，所以公差的取值范围为[-500, 500]
        int[][] dp = new int[nums.length][1001];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 1;
            }
        }

        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            // 枚举前边的数作为子序列的上一个数
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                ans = Math.max(dp[i][d], ans);
            }
        }
        return ans;
    }
//    1105. 填充书架
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int maxHeight = 0, curWidth = 0;
            for (int j = i; j >= 0; --j) {
                curWidth += books[j][0];
                if (curWidth > shelfWidth) {
                    break;
                }
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
            }
        }
        return dp[n];
    }
}

