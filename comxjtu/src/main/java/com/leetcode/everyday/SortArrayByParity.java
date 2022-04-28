package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/4/28 15:54
 * @description //LC905
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 返回满足此条件的 任一数组 作为答案。
 */
public class SortArrayByParity {



    /**
     *
     * @Param
     * @Description 方法一：双指针（类似于快速排序的partition）
     * 双指针：前后指针，时间复杂度为O(N)
    1.前指针为偶数指针evenIndex,从0开始往后走，直到当前值为偶数或者交换后为偶数往后继续，
    2.后指针为奇数指针oddIndex
    3.终止条件evenIndex>=oddIndex，
     * @Date 17:46 2022/4/28
     * @return
     **/
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 1){
            return nums;
        }
        int evenIndex = 0, oddIndex = nums.length-1;
        while (evenIndex < nums.length && oddIndex > 0 && evenIndex < oddIndex){
            if (nums[evenIndex]%2 == 0){
                evenIndex++;
            }else if (nums[oddIndex]%2 == 0){
                int tmp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = tmp;
                evenIndex++;
                oddIndex--;
            }else {
                oddIndex--;
            }
        }
        return nums;
    }
}
