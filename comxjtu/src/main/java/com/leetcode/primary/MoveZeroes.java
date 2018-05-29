package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 18:29 2018/5/29
 * @Modified By:
 */

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 示例:
 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums==null||nums.length==0||nums.length==1) return;
        int zeronum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i]==0){
                for (int j=i;j<nums.length-1-zeronum;j++) {
                    nums[j]=nums[j+1];
                }
                nums[nums.length-1-zeronum]=0;
                zeronum++;
            }
        }
    }
}
