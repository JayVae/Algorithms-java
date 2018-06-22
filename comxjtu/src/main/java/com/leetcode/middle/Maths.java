package com.leetcode.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jay
 * @Date: Created in 21:40 2018/6/21
 * @Modified By:
 */
public class Maths {
    /**
     * 判断是不是快乐数
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n < 1) return false;
        int ans = n;
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (ans == 1) return true;
            if (set.contains(ans)) return false;
            set.add(ans);
            char[] s = String.valueOf(ans).toCharArray();
            int tmp = 0;
            for (int i = 0; i < s.length; i++) {
                tmp += (s[i] - 48) * (s[i] - 48);
            }
            ans = tmp;
        }
    }

    /**
     * 阶乘后的零：给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int rvl = 0;
        while (n > 0) {
            rvl += n / 5;
            n = n / 5;
        }
        return rvl;
    }

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int base = 26, len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res + (s.charAt(i) - 64) * (int) Math.pow(base, len - 1 - i);
        }
        return res;
    }

    /**
     * 二分法求幂
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x==1||x==0) return x;
        if (x==-1){
            if (n%2==0) return 1;
            else return -1;
        }
        double ans = 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = n / 2;
                ans = 1/x;
            }
            n = 0 - n;
            while (n > 0) {
                ans = ans * 1/x;
                n--;
                if (Math.abs(ans)<0.00000000001) break;
            }

        } else {
            while (n > 0) {
                ans = ans * x;
                n--;
                if (Math.abs(ans)<0.00000000001) break;
            }
        }
        return ans;
    }

    public double myPow2(double x, int n) {
        if(n==0)return 1;
        boolean signFlag = true;
        if(n<0){
            signFlag = false;
            n=-n;
        }
        double posRes = positivePow(x,n);
        if(signFlag)return posRes;
        return 1/posRes;
    }
    public double positivePow(double x, int n){
        if(n==0)return 1;
        if(n==1)return x;
        double res = positivePow(x,n/2);
        res = res*res;
        if(n%2!=0)res = res*x;
        return res;
    }
    public double myPow3(double x, int n) {
        double pow = 1.0;
        x = n >= 0 ? x : 1 / x;
        n = (n >= 0) ? n : n * -1;
        while (n != 0) {
            if ((n&1) != 0) { // n % 2 != 0
                pow *= x;
            }
            x *= x;
            n /= 2; // n /= 2
        }
        return pow;
    }

    /**
     * 二分法求平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public int divide(int dividend, int divisor) {

    }
    public String fractionToDecimal(int numerator, int denominator) {

    }
}
