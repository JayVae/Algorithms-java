package com.leetcode.base;

/**
 * @Author: Jay
 * @Date: Created in 9:23 2018/9/4
 * @Modified By:
 */
public class Yuesefu {

    /**
     * 递推关系式：Jq(n+1) = ( Jq(n) + q ) %(n+1)。
     * 根据递推关系，根据1人约瑟夫问题的解为它本身，求出n人约瑟夫问题的解
     * - n — n人构成的约瑟夫环
     - q — 每次移除第q个人
     约定：
     - Jq(n)表示n人构成的约瑟夫环，每次移除第q个人的解
     - n个人的编号从0开始至n-1
     当q为2时，有J(2^k + t) = 2t+1（也就是编号为2t）
     * @param m
     * @param n
     * @return
     */
    public static int getYuesefu(int m,int n){
        if (n==1) return 0;
        return (getYuesefu(m,n-1)+m)%n;
    }

    public static int getYuesefu2(int m,int n){
        int k=0;
        for (int i = 2; i <= n; i++) {
            k=(k+m)%i;
        }
        return k;
    }

    public static void main(String[] args){
        System.out.println(getYuesefu(2,4));
        System.out.println(getYuesefu2(2,4));
        System.out.println(getYuesefu(2,11));
    }
}
