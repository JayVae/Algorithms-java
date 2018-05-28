package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 10:31 2018/5/28
 * @Modified By:
 */

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 你可以假设数组中无重复元素。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,target);
    }

    public int binarySearch(int[] nums, int target){
        int lo = 0, hi=nums.length-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if (nums[mid]<target) lo=mid+1;
            else if (nums[mid]>target) hi=mid-1;
            else return mid;
        }
        return lo;
    }
}
