package com.leetcode.otherSet.number;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/10 12:14
 * @description //1071. 字符串的最大公因子
 */
public class GcdofStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
