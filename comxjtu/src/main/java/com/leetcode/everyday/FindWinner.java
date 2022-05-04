package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/4 9:22
 * @description //lc1823
 */
public class FindWinner {


    /**
     *
     * @Description //
     * 初始思路：使用一个数组来记录出局，然后不断循环该数组，直到只有一个未出局即可；
     * 进一步：使用的记录数组比较麻烦，每次都要判断----->用队列，直接将出局的弹出即可；
     * 另一种：约瑟夫环问题，关键在于找到递归表达式，递推公式： f(n)= (f(n - 1) + k - s) % n + 1 (s 代表起点编号)
     * @Date 9:44 2022/5/4
     * @return
     **/
    public int findTheWinner(int n, int k) {
        if (n<2) return n;
        int count = n, start = 1, itrK = 1;
        boolean[] flags = new boolean[n+1];
        while (count!=1){

            if (flags[start]){
                //已被淘汰
            }else {
                if (itrK==k){
                    flags[start]=true;
                    count--;
                    itrK=1;
                }
                else itrK++;
            }
            if (start==n) start=1;
            else start++;
        }
        for (int i = 1; i < n+1; i++) {
            if (!flags[i]) return i;
        }
        return n;
    }

    public int findTheWinner2(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinner2(n - 1, k) - 1) % n + 1;
    }
}
