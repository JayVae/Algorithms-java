package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/19 10:43
 * @description //力扣 1079. 活字印刷
 *
 */
public class NumTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return dfs(count);
    }

    private int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }
            sum++;
            arr[i]--;
            sum += dfs(arr);
            arr[i]++;
        }
        return sum;
    }
}
