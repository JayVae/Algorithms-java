package com.leetcode.otherSet.qianzhuihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 15:53
 * @description //2602. 使数组元素全部相等的最少操作次数:前缀和+二分查找.
 * 这道题如果场规使用每次循环处理就会超时；因此考虑其实每次都是对原数组的查询，因此尝试是否可以用前缀和。
 */
public class MinOperations {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] sum = new long[n + 1]; // 前缀和
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];

        List<Long> ans = new ArrayList<>(queries.length);
        for (int q : queries) {
            int j = lowerBound(nums, q);
//            int j = Arrays.bi(nums, q);
            long left = (long) q * j - sum[j]; // 蓝色面积
            long right = sum[n] - sum[j] - (long) q * (n - j); // 绿色面积
            ans.add(left + right);
        }
        return ans;
    }

    // 见 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right;
    }

    public static void main(String[] args) {
        MinOperations solver = new MinOperations();
        int[] nums = new int[]{2,9,6,3};
        int[] queries = new int[]{10,3};
        System.out.println(solver.minOperations(nums, queries).toString());
    }
}
