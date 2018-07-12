package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 16:26 2018/7/12
 * @Modified By:
 */
public class lc209 {
    /**
     * 长度最小的子数组：
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组。如果不存在符合条件的子数组，返回 0。
     * 双指针：滑动窗口
     *  @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length<1) return 0;
        int lo = 0,hi=-1;//[lo,hi]中是满足条件的子数组
        int sum =0;
        int res = nums.length+1;
        while (lo<nums.length){
            if (hi+1<nums.length && sum<s){
                hi++;
                sum = sum+nums[hi];
            }else {
                sum -= nums[lo++];
            }
            if (sum>=s){
                res = Math.min(res,hi-lo+1);
            }
        }
        if (res == nums.length+1)
            return 0;
        return res;
    }
}
