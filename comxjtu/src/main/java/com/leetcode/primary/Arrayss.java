package com.leetcode.primary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JS
 * @version 1.0
 * @date 2022/4/30 10:40
 * @description //力扣-初级算法-数组专题
 */
public class Arrayss {

    /**
     *
     * @Description //买卖股票的最佳时机 II，
     * 思路：可以多次买卖。只要遇到低价就买，买之前就抛出.
     * @Date 10:42 2022/4/30
     * @return
     **/
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = Integer.MIN_VALUE, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        }
        return profit;
    }

    /**
     *
     * @Description //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。
    思路：其实就是确定一个数之后的查找问题。先排序，然后选定一个数，再二分查找.[排序方法是错误的，因为会改变下标]
    方法二：用hashMAp
     * @Date 11:01 2022/4/30
     * @return
     **/
/*    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <2) return null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int fix = nums[i];
            int other = binarySearch(nums, target - fix, i+1, nums.length-1);
            if (other!= -1) return new int[]{i,other};
        }
        return null;
    }*/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    private int binarySearch(int[] nums, int val, int lo, int hi) {

        while (lo <= hi){
            int mid = (hi-lo)/2 +lo;
            if (nums[mid] == val) return mid;
            if (nums[mid] < val) lo = mid+1;
            else hi = mid-1;
        }

        return -1;
    }

    /**
     *
     * @Description //请你判断一个初始的 9 x 9 的数独是否有效。
     * 方法一：用三个独立的for循环来做，分别判断行、列、宫格，每个循环里只需要一个map空间。
     * 方法二：一个独立的for循环，空间变大了，需要19个map。map可以改造成位运算的数组
     * @Date 11:50 2022/4/30
     * @return
     **/
    public boolean isValidSudoku(char[][] board) {
        int[] line = new int[9];
        int[] column = new int[9];
        int[] cell = new int[9];
        int shift = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
                //由行、列得到宫格编号
                int k = (i / 3) * 3 + j / 3;

                //board[i][j] - '0'表示字符表示的数字N，将1左移N位，即将第N位置1，也就是当前列（行、宫格）有了。
                shift = 1 << (board[i][j] - '0');

                //如果对应的位置只要有一个大于0，说明有冲突，直接返回false
                if ((column[i] & shift) > 0 || (line[j] & shift) > 0 || (cell[k] & shift) > 0)
                    return false;
                column[i] |= shift;
                line[j] |= shift;
                cell[k] |= shift;
            }
        }
        return true;
    }
}
