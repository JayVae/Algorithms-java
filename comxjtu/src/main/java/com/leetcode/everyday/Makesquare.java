package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2022/6/1 10:26
 * @description 473. 火柴拼正方形
 */
public class Makesquare {

    class Solution {
        public boolean makesquare(int[] matchsticks) {
            int totalLen = Arrays.stream(matchsticks).sum();
            if (totalLen % 4 != 0) {
                return false;
            }
            Arrays.sort(matchsticks);
            for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
                int temp = matchsticks[i];
                matchsticks[i] = matchsticks[j];
                matchsticks[j] = temp;
            }

            int[] edges = new int[4];
            return dfs(0, matchsticks, edges, totalLen / 4);
        }

        public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
            if (index == matchsticks.length) {
                return true;
            }
            for (int i = 0; i < edges.length; i++) {
                edges[i] += matchsticks[index];
                if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                    return true;
                }
                edges[i] -= matchsticks[index];
            }
            return false;
        }
    }
}
