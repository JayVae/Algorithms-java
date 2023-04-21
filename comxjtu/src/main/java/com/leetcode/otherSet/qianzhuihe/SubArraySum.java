package com.leetcode.otherSet.qianzhuihe;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 10:46
 * @description //560. 和为 K 的子数组
 */
public class SubArraySum {


/**
 *
 * @Param
 * @Description //hashmap+前缀和
 * @Date 10:51 2023/4/21
 * @return
 **/    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
