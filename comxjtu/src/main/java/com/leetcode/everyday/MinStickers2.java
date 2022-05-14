package com.leetcode.everyday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/14 20:15
 * @description //691:这个解答实现错了，将重复选用的记为一次了；如果不记为一次，则使用map数组来做、
 */
public class MinStickers2 {
    class Solution {
        public int minStickers(String[] stickers, String target) {
            int m = target.length();
            int[] memo = new int[1 << m];
            Arrays.fill(memo, -1);
            memo[0] = 0;
            int res = dp(stickers, target, memo, (1 << m) - 1);
            return res <= m ? res : -1;
        }

        public int dp(String[] stickers, String target, int[] memo, int mask) {
            int m = target.length();
            if (memo[mask] < 0) {
                int res = m + 1;
                for (String sticker : stickers) {
                    int left = mask;
                    int[] cnt = new int[26];
                    for (int i = 0; i < sticker.length(); i++) {
                        cnt[sticker.charAt(i) - 'a']++;
                    }
                    for (int i = 0; i < target.length(); i++) {
                        char c = target.charAt(i);
                        if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                            cnt[c - 'a']--;
                            left ^= 1 << i;
                        }
                    }
                    if (left < mask) {
                        res = Math.min(res, dp(stickers, target, memo, left) + 1);
                    }
                }
                memo[mask] = res;
            }
            return memo[mask];
        }
    }
}
