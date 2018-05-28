package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 21:05 2018/5/27
 * @Modified By:
 */

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicate {

    public int removeDuplicates(int[] nums) {
        int shift = 0;
        int len = nums.length;
        if (len==0) return 0;
        if (len==1) return 1;
//        boolean last = (nums[len-1]==nums[len-2]);
        for (int i = 0; i < len-1; i++) {
            if (nums[i]==nums[i+1]){
                shift++;
            }else {
                nums[i-shift] = nums[i];
            }
        }
        if (len>=2){
            if (nums[len-2]==nums[len-1]){
                nums[len-1-shift]=nums[len-1];
            }else {
                nums[len-1-shift]=nums[len-1];
            }
        }
//        for (int i = 0; i < len-shift; i++) {
//            System.out.println(nums[i]);
//        }
        return len-shift;
    }
}
