package com.leetcode.Question;

import java.util.Arrays;

public class lc300 {

    public static void main(String[] args) {

    }

    /**
     * 最长递增子序列(动态规划)
     * @param nums
     * @return
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     */
    public int lengthOfLIS(int[] nums) {
        //处理边界

        //状态定义：dp[i]表示以nums[i]为结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        int max = 1;

        //初始化
        Arrays.fill(dp,1);

        for (int i = 0; i < nums.length; i++) {
            //状态转移方程：将nums[i]添加入最长递增子序列或不。
            //需要和之前的所有进行比较
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划改良版
     * @param nums
     * @return
     * 降低复杂度切入点：
     * 解法一中，遍历计算 dpdp 列表需 O(N)O(N)，计算每个 dp[k]dp[k] 需 O(N)O(N)。
    动态规划中，通过线性遍历来计算 dpdp 的复杂度无法降低；
    每轮计算中，需要通过线性遍历 [0,k)[0,k) 区间元素来得到 dp[k]dp[k] 。我们考虑：是否可以通过重新设计状态定义，
    使整个 dpdp 为一个排序列表；这样在计算每个 dp[k]dp[k] 时，就可以通过二分法遍历 [0,k)[0,k) 区间元素，
    将此部分复杂度由 O(N)O(N) 降至 O(logN)O(logN)。
     */
    public int lengthOfLIS2(int[] nums) {
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
}
