package com.leetcode.topinterview150.array;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/9 15:12
 * @description //位运算
 */
public class weiyunsuan {

    /*
    * 67. 二进制求和
    * */
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
/*
* 190. 颠倒二进制位
* */
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32 && n!=0; i++) {
            ans |= (n&1)<<(31-i);
            n >>>= 1;
        }
        return ans;
    }
/*
* 191. 位1的个数
* */
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

/*
* 136. 只出现一次的数字
* */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^=num;
        }
        return ans;
    }
/* 137. 只出现一次的数字 II
*  除某个元素仅出现 一次 外，其余每个元素都恰出现 三次.
*  答案的第 i 个二进制位就是数组中所有元素的第 i 个二进制位之和除以 3 的余数。
 * */
    public int singleNumberII(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
/*
201. 数字范围按位与
题目描述：给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
*  这个问题的实质：给定两个整数，我们要找到它们对应的二进制字符串的公共前缀。
两种方法：（1）位移
（2）Brian Kernighan 算法  ，利用 n=n & (n - 1)抹去最低位的1
* */
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}
