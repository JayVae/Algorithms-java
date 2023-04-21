package com.leetcode.otherSet.qianzhuihe;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 9:35
 * @description //209. 长度最小的子数组
 */
public class MinSubArrayLen {

    /**
     *
     * @Param
     * @Description //下面这个方法将两种方法杂糅在一起了：
     * 1. 前缀和+二分查找；
     * 2. 滑动窗口，双指针
     * @Date 10:14 2023/4/21
     * @return
     **/
    public int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
//        nums[i] = sum[i+1] - sum[i]
        for (int i = 1, j=0; i < nums.length+1; ) {
            if (sum[i] - sum[j]>=target){
                if (ans!=0) {
                    ans = Math.min(ans, i-j);
                }else {
                    ans = i - j;
                }
                j++;
            }else {
                i++;
            }
        }
        return ans;
    }
}
