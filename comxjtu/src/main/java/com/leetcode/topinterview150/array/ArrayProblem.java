package com.leetcode.topinterview150.array;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/26 10:12
 * @description //数组/字符串问题
 * 来源：https://leetcode.cn/studyplan/top-interview-150/
 */
public class ArrayProblem {
    /**
     * 1.合并两个有序数组
     * 题目：https://leetcode-cn.com/problems/merge-sorted-array/
     * 解题思路：双指针
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     * @param nums1 有序数组1
     * @param m 有序数组1的长度
     * @param nums2 有序数组2
     * @param n 有序数组2的长度
     * @return 合并后的有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        System.arraycopy(sorted, 0, nums1, 0, m + n);
//        不能使用Arrays.copyOf()方法，因为将 nums1 引用指向了新的数组。但是，这么做的问题在于返回值没有办法传递到函数调用者。因为Java是采用按值传递的方式传递参数，nums1 只是指向一个数组的引用，函数的调用者在函数外部无法看到该引用被赋值后所指向的新的数组，也就是说函数的调用者并不能得到正确的合并后数组。因此，需要在不新建数组的情况下直接在 nums1 中进行操作，才能满足题目的要求。
//        nums1 = Arrays.copyOf(sorted, m + n);
    }

    /**
     * 2.移除元素
     * 题目：https://leetcode-cn.com/problems/remove-element/
     * 解题思路：双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 数
     */
    public int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == val) {
                while (p1 <= p2 && nums[p2] == val) {
                    p2--;
                }
                if (p1 <= p2) {
                    nums[p1] = nums[p2];
                }
                p2--;
            } else {
                p1++;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        ArrayProblem solver = new ArrayProblem();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        solver.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums = {3,2,2,3};
        System.out.println(solver.removeElement(nums, 3));
//        nums = [0,1,2,2,3,0,4,2], val = 2
        nums = new int[]{3,3};
        System.out.println(solver.removeElement(nums, 5));
    }
}
