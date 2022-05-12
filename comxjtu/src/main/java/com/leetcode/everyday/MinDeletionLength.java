package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/12 9:41
 * @description //lc944
 */
public class MinDeletionLength {

    public int minDeletionSize(String[] strs) {
        if (strs.length==1 ) return 0;
        int sum =0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i)<strs[j-1].charAt(i)){
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }
}
