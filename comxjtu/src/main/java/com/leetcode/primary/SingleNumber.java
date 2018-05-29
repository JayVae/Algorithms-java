package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 15:18 2018/5/29
 * @Modified By:
 */

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 Hint:方法二使用了异或运算比较是否有相同。
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int N = nums.length;
        if (nums==null || N%2==0) return 0;
        else if ( N==1) return nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < N-1; i=i+2) {
            if (nums[i]!=nums[i+1]) return nums[i];
        }
        return nums[N-1];
    }

    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            flag ^= nums[i];
        }
        return flag;
    }
}
