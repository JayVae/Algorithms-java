package com.leetcode.otherSet.qianzhuihe;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 11:02
 * @description //713. 乘积小于 K 的子数组
 * 这个问题可以看作是前缀和的变式，前缀积（可以处理为对数）或者滑动窗口
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }
}
