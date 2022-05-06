package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/5 9:09
 * @description //LC713 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 */
public class NumSubarray {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<k){
                count++;
                int ans = nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    if (ans*nums[j]<k){
                        ans = ans*nums[j];
                        count++;
                    }else break;
                }
            }
        }
        return count;
    }

}
