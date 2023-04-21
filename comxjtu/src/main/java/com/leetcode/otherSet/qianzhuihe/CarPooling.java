package com.leetcode.otherSet.qianzhuihe;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 17:38
 * @description //1094. 拼车:差分数组。
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
//        diff[i] = capacity[i] - capacity[i-1]
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
//          这里不是diff[trip[2]+1]计算的原因：[from,to)是左闭右开区间，to位置时乘客已经下车，不占用车的容量
            diff[trip[2]] -= trip[0];
        }
        int peopleNow = 0;
        for (int i = 0; i < diff.length-1; i++) {
            peopleNow += diff[i];
            if (peopleNow>capacity) return false;
        }
        return true;
    }
}
