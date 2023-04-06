package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/6 12:02
 * @description //TODO
 */
public class BaseNeg2 {
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            res.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return res.reverse().toString();
    }
}
