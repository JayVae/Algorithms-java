package com.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/13 10:03
 * @description //2475. 数组中不等三元组的数目
 */
public class UnequalTriplets {

    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.merge(x, 1, Integer::sum);
        }
        int res = 0, n = nums.length, t = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            res += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        UnequalTriplets solver = new UnequalTriplets();
        int ans = solver.unequalTriplets(new int[]{1,3,1,2,4});
        System.out.println(ans);
    }
}
