package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/29 16:26
 * @description //2455. 可被三整除的偶数的平均值
 */
public class AverageValue {

    public int averageValue(int[] nums) {
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            if (num%6==0) {
                count++;
                sum += num;
            }
        }
        return count==0? 0 : sum/count;
    }
}
