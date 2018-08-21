package com.leetcode.Question;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jay
 * @Date: Created in 18:23 2018/8/21
 * @Modified By:
 */
public class lc219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length<2) return false;
        boolean res = false;
        Set set = new HashSet<Integer>(k);
        for (int i = 0; i < k+1; i++) {
            if (i>nums.length-1){
                return false;
            }
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        for (int i = k+1; i < nums.length; i++) {
            set.remove(nums[i-k-1]);
            if (set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
