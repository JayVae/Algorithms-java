package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/5 16:21
 * @description //2427. 公因子的数目
 */
public class CommonFactors {
    public int commonFactors(int a, int b) {
        int c = gcd(a, b), ans = 0;
        for (int x = 1; x * x <= c; ++x) {
            if (c % x == 0) {
                ++ans;
                if (x * x != c) {
                    ++ans;
                }
            }
        }
        return ans;
    }

//    最大公约数
    public int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return a;
    }
}
