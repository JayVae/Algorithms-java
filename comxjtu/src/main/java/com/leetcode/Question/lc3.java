package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 16:56 2018/7/12
 * @Modified By:
 */
public class lc3 {
    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;

        int[] freq = new int[256];
        int lo = 0,hi=-1;
        int res =0;

        while (lo<s.length()){
            if (hi+1<s.length() && freq[s.charAt(hi+1)]==0){
                freq[s.charAt(++hi)]++;
            }else{
                freq[s.charAt(lo++)]--;
            }
            res = Math.max(res,hi-lo+1);
        }
        return res;
    }
}
