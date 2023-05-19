package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/19 12:07
 * @description //力扣 39. 组合总和 使用动态规划算法
 * 0-1背包问题
 * dp[i]表示和为i的组合总数
 * 状态转移方程：dp[i] = dp[i] + dp[i - candidates[j]]
 * 可以参考：
 * https://leetcode.cn/problems/combination-sum/solution/chao-qiang-gifzhu-ni-shi-yong-dong-tai-gui-hua-qiu/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 1.定义dp数组
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        // 2.初始化
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
        // 3.遍历
        for (int i = 0; i < candidates.length; i++) {
            for (int j = candidates[i]; j <= target; j++) {
                // 4.状态转移方程
                if (dp[j - candidates[i]] != null) {
                    if (dp[j] == null) {
                        dp[j] = new ArrayList<>();
                    }
                    for (List<Integer> list : dp[j - candidates[i]]) {
                        List<Integer> tmp = new ArrayList<>(list);
                        tmp.add(candidates[i]);
                        dp[j].add(tmp);
                    }
                }
            }
        }
        return dp[target] == null ? new ArrayList<>() : dp[target];
    }
}
