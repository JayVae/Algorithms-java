package com.leetcode.Question;

public class lc198 {
    public static void main(String[] args) {
    }

    public int rob(int[] nums) {

        //入参判断及边界控制
        if (nums == null || nums.length == 0){
            return 0;
        }

        // 状态定义：dp[i]表示第i个房子获得最大值
        //因为第 i 个位置和前面的两个位置都有关，这个时候我们可以把状态多开一格，dp[0] 表示的是一个房子都不抢的状态
        int[] dp = new int[nums.length+1];

        //初始化
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            //状态转移方程:两种情况，抢或不抢
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }

        return dp[nums.length];
    }
}
