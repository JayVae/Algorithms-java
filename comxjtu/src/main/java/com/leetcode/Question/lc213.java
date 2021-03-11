package com.leetcode.Question;

import java.util.Arrays;

public class lc213 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;

        return Math.max(
                robI(Arrays.copyOfRange(nums, 0, n - 1)),
                robI(Arrays.copyOfRange(nums, 1, n))
        );
    }

    public int robI(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] dp = new int[n + 1];

        dp[1] = nums[0];

        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }
}
