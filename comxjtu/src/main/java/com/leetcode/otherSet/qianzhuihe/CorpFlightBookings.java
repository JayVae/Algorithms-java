package com.leetcode.otherSet.qianzhuihe;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 17:59
 * @description //1109. 航班预订统计
 */
public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+2];
        for (int[] booking : bookings) {
            diff[booking[0]] += booking[2];
            diff[booking[1]+1] -= booking[2];
        }
        int[] ans = new int[n];
        ans[0] = diff[1];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1] + diff[i+1];
        }
        return ans;
    }
}
