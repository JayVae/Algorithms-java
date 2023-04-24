package com.leetcode.everyday;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/24 9:00
 * @description //1163. 按字典序排在最后的子串
 * 双指针
 */
public class LastSubstring {

    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }

    public static void main(String[] args) {
        LastSubstring solver = new LastSubstring();
        String s = "leetcode";
        System.out.println(solver.lastSubstring(s));
    }
}
