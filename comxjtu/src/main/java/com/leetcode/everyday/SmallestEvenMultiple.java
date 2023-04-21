package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 9:26
 * @description //2413. 最小偶倍数
 */
public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        if (n<=2) return 2;
        if ((n&1)==0) return n;
        return n*2;
    }
}
