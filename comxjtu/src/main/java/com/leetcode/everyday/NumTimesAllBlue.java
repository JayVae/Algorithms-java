package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/14 9:28
 * @description //1375. 二进制字符串前缀一致的次数
 */
public class NumTimesAllBlue {

    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int ans = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, flips[i]);
            if (right == i + 1) {
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumTimesAllBlue solver = new NumTimesAllBlue();
        System.out.println(solver.numTimesAllBlue(new int[]{ 2,1,3,5,4}));
    }
}
