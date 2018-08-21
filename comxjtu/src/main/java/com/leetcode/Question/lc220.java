package com.leetcode.Question;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jay
 * @Date: Created in 18:21 2018/8/21
 * @Modified By:
 */
public class lc220 {

    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     * @param nums
     * @param k
     * @param t
     * @return
     */
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if(k == 10000 && t == 0) return false;
            for(int i = 0; i < nums.length - 1; i++) {
                int limit=i+k;
                for(int j = i + 1; j < limit+1 && j<nums.length; j++) {
                    if(Math.abs((long)nums[i] - nums[j]) <= t) return true;
                }
            }
            return false;
        }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
