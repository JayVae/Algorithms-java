package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/21 16:54
 * @description //LCP 33. 蓄水
 */
public class StoreWater {

    public int storeWater(int[] bucket, int[] vat) {
        int maxk = Arrays.stream(vat).max().getAsInt();
        if (maxk == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = 1; k <= maxk && k < res; ++k) {
            int t = 0;
            for (int i = 0; i < bucket.length; ++i) {
                t += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            res = Math.min(res, t + k);
        }
        return res;
    }
}
