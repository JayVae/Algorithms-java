package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/7 18:16
 * @description //1010. 总持续时间可被 60 整除的歌曲
 */
public class NumPairsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        for (int t : time) {
            cnt[t % 60]++;
        }
        long res = 0;
        for (int i = 1; i < 30; i++) {
            res += cnt[i] * cnt[60 - i];
        }
        res += (long) cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
        return (int) res;
    }
}
