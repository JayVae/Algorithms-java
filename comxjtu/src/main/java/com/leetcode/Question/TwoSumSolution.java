package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 9:06 2018/5/25
 * @Modified By:
 */
public class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2)
            return res;


        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i])
                max = nums[i];
            if (min > nums[i])
                min = nums[i];
        }

        int[] index = new int[max - min + 1];
        int other = 0;
        for (int i = 0; i < nums.length; i++) {
            // if (index[target - numbers[i] + min ] == 0) {
            // }
            other = target - nums[i];
            if (other < min || other > max) {
                continue;
            }
            if (index[other - min] > 0) {
                res[0] = index[other - min] - 1;
                res[1] = i;
                return res;
            }
            index[nums[i] - min] = i + 1;
        }
        return res;
    }

    public int binarySearch(int[] nums, int k, int i) {
        int res = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (k < nums[mid]) hi = mid - 1;
            else if (k > nums[mid]) lo = mid + 1;
            else if (mid == i) return mid + 1;
            else return mid;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 2, 3};
        int[] ans = new TwoSumSolution().twoSum(test, 6);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
