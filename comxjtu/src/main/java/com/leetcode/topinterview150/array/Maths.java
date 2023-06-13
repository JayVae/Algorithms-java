package com.leetcode.topinterview150.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/9 10:36
 * @description //数学专题
 * https://leetcode.cn/studyplan/top-interview-150/
 */
public class Maths {
/*
* 9. 回文数
* 最基础的是转换为字符串，双指针判断；
* 也可以对数字逐次判断头尾。然后再将数字掐头去尾更新，直至结束。
* */
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x<10) return true;

        int base = 10;
        int baseMax = 1000000000;
        while (x/base !=0){
            if (base==baseMax) break;
            base *= 10;
        }
        if (base!=baseMax) base /= 10;

        while (x!=0){
            if (base==1) return true;
            if (x/base != x%10) return false;
            x = (x - x/base * base -x%10)/10;
            base /= 100;
        }
        return true;
    }

/*
* 66. 加一
* 需要注意的是最后一位为9时，需要逐个往前进1，最严重时还会在前面增加1位。
* */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int acc = 0;
        if (digits[n-1]==9){
            digits[n-1]=0;
            acc = 1;
        }else digits[n-1]+=1;
        for (int i = n-2; i > -1; i--) {
            digits[i] += acc;
            if (digits[i]>9){
                digits[i] %= 10;
                acc =1;
            }else acc = 0;
        }
        if (acc==0) return digits;
        else {
            int[] ans = new int[n+1];
            Arrays.fill(ans, 0);
            ans[0] = 1;
            return ans;
        }
    }
/*
* 172. 阶乘后的零
* 看阶乘式子中有几个5的倍数即可；因为每一个5的范围内都会有一个偶数与其相乘得到10；
* */
    public int trailingZeroes(int n) {
        int ans = 0;
        int a = 5;
        while (a<=n){
            ans += n/a;
            a *= 5;
        }
        return ans;
    }

    /*
    * 69. x 的平方根
     * */
    public int mySqrt(int x) {
        if (x<2) return x;
        int ans = 0;
        int l = 0, r=x/2;
        while (l<=r){
            int mid = l + (r-l)/2;

            if ((long)mid*mid==x) return mid;
            else if ((long)mid*mid>x){
                r=mid-1;
            }
            else {
                l = mid+1;
            }
        }
//        mid可能是答案
        return l-1;
    }


    /*
    *  50. Pow(x, n)  快速幂
    * 分治法
    * */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
    /*
    * 149. 直线上最多的点数
    * */
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
// 当我们找到一条直线经过了图中超过半数的点时，我们即可以确定该直线即为经过最多点的直线；
//当我们枚举到点i（假设编号从0开始）时，我们至多只能找到n−i 个点共线。假设此前找到的共线的点的数量的最大值为k，如果有k≥n−i，那么此时我们即可停止枚举，因为不可能再找到更大的答案了。
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        Maths m = new Maths();
        System.out.println(m.isPalindrome(1000000001));
    }
}
