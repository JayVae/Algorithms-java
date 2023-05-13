package com.leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/13 21:46
 * @description //2441. 与对应负数同时存在的最大正整数
 */
public class FindMaxK {
//    给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。返回正整数 k ，如果不存在这样的整数，返回 -1 。
    public int findMaxK(int[] nums) {
        int k = -1;
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            set.add(x);
        }
        for (int x : nums) {
            if (set.contains(-x)) {
                k = Math.max(k, x);
            }
        }
        return k;
    }

}
