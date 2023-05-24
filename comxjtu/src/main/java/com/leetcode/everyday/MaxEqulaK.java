package com.leetcode.everyday;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/24 12:21
 * @description //
 */
public class MaxEqulaK {

//    使用哈希表+前缀和
    public int maxlenEqualK (int[] arr, int k) {
        // write code here
        int n = arr.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + arr[i-1];
        }
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (list.contains(preSum[i] - k)) {
                res = Math.max(res, i - list.indexOf(preSum[i] - k));
            }
            if (!list.contains(preSum[i])) {
                list.add(preSum[i]);
            }
        }
        return res;
    }


}
