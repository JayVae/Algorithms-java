package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/19 11:45
 * @description //1262. 可被三整除的最大和
 */
public class MaxSumDivThree {

    public int maxSumDivThree(int[] nums) {
        int[] f = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] g = new int[3];
            System.arraycopy(f, 0, g, 0, 3);
            for (int i = 0; i < 3; ++i) {
                g[(i + num % 3) % 3] = Math.max(g[(i + num % 3) % 3], f[i] + num);
            }
            f = g;
        }
        return f[0];
    }
}
