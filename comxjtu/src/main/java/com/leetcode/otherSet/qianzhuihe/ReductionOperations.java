package com.leetcode.otherSet.qianzhuihe;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 16:41
 * @description //1887. 使数组元素相等的减少操作次数
 * 这个排序即可。【不是前缀和问题】
 */
public class ReductionOperations {

    public int reductionOperations(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);

        if (nums.length<=1) return 0;
        for (int i = nums.length-1; i >=0 ;i-- ) {
            while (i>=1 && nums[i-1]==nums[i]){
                i--;
            }
            if (i==0) return ans;
            ans += nums.length-1 - (i-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        ReductionOperations solver = new ReductionOperations();
        int[] nums = new int[]{1, 1, 1};
        System.out.println(solver.reductionOperations(nums));
    }
}
