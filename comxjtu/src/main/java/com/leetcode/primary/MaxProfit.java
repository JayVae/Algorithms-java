package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 19:49 2018/5/28
 * @Modified By:
 */

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0 || prices.length==1) return 0;
        int sum=0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i]<prices[i+1]) sum =sum+ prices[i+1]-prices[i];
        }
        return sum;
    }
}
