package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2022/4/30 10:22
 * @description //lc908:
 * 给你一个整数数组 nums，和一个整数 k 。
在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
nums 的 分数 是 nums 中最大和最小元素的差值。 
在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数
 */
public class SmallestRangeI {

    /**
     *
     * @Param
     * @Description //使用排序后就一目了然了,最大值和最小值的转换代价最大，所以只需要计算最大和最小即可；
     * 其实也不需要排序，找出最大值最小值就行。
     * @Date 10:23 2022/4/30
     * @return
     **/
    public int smallestRangeI(int[] nums, int k) {
        if (nums == null || nums.length<2) return 0;
//        Arrays.sort(nums);
//        int ans = nums[nums.length-1]-nums[0] - 2*k;
        int max = -1, min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
            if (min > nums[i]) min = nums[i];
        }
        int ans = max - min - 2*k;
        return ans<=0 ? 0 : ans;
    }
}
