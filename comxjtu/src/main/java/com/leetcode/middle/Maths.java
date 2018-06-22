package com.leetcode.middle;

import java.util.HashMap;
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
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }
    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public int divide2(int dividend, int divisor) {
        //由于处理不了最小值，我们分解最小值成可以进行计算
        //同时要保证这种分解不会对最后结果产生影响
        if(dividend==Integer.MIN_VALUE){
            if(divisor==-1)return Integer.MAX_VALUE;
            else{
                //第二位上是不一定是二的幂;
                //if((divisor&0x2)==0x2) 是错误的
                if((divisor&(divisor-1))==0){
                    int val = divide(dividend+1,divisor);
                    return val>=0?val+1:val-1;
                }else{
                    return divide(dividend+1,divisor)+divide(-1,divisor);
                }
            }
        }
        //dividend！=min &&divisor==min
        if(divisor==Integer.MIN_VALUE){
            return 0;
        }
        // 除法刻意视为一种特殊的减法，问题是如果加快这种减法，而不是一个一个减
        boolean neg = ((divisor&0x80000000)!=(dividend&0x80000000));
        dividend = dividend<0?-dividend:dividend;
        divisor = divisor<0?-divisor:divisor;
        int count = dividend<divisor? 0:1;
        int temp = divisor;
        //注意最接近dividend的temp值的描述方法
        int result = 0 ;
        while(dividend>=divisor){
            while(temp<=dividend){
                //所有的都规约到整数的逻辑右移
                int pre = temp<<1;
                boolean br = (pre<0)||(pre>dividend);
                if(br)break;
                temp = pre;
                count<<=1;
            }
            dividend-=temp;
            result+=count;
            //回正
            temp=divisor;
            count=1;
        }
        return neg?-result:result;
    }
    //o1 判断是否是二的幂
    private boolean isTwoPow(int val){
        return ((val-1)&val)==0;
    }


    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
