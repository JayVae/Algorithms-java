package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/9 17:09
 * @description //TODO
 */
public class DiStringMatch {

    public int[] diStringMatch(String s) {
        int[] reslut = new int[s.length()+1];
        int max = s.length(), min = 0;
        for (int i = 0; i < s.length(); i++)
            reslut[i] = s.charAt(i)=='I'?reslut[i]=min++:max--;
        reslut[s.length()] = s.charAt(s.length()-1)=='I'? min : max;
        return reslut;
    }
}
