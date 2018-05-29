package com.leetcode.primary;

import java.util.*;

/**
 * @Author: Jay
 * @Date: Created in 14:53 2018/5/29
 * @Modified By:
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums==null || nums.length==0) return false;
        Set tSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (tSet.contains(nums[i])) return true;
            tSet.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{3,1}));
    }
}
