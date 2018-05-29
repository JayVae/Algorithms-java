package com.leetcode.primary;

import java.util.Arrays;

/**
 * @Author: Jay
 * @Date: Created in 21:22 2018/5/29
 * @Modified By:
 */
public class Strings {
    /**
     * 请编写一个函数，其功能是将输入的字符串反转过来。
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if (s==null || s.isEmpty()) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = tmp;
        }
        return new String(chars);
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * 案例:
     s = "leetcode"返回 0.
     s = "loveleetcode",返回 2.
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s==null || s.isEmpty()) return -1;
        if (s.length()==1) return 0;
        char[] chars = s.toCharArray();
        boolean[] booleans = new boolean[chars.length];
        for (int i = 0; i < chars.length-1; i++) {
            boolean flag = false;
            if (booleans[i]==true) {
                continue;
            };
            for (int j = i+1; j < chars.length; j++) {
                if (chars[i]==chars[j]){
                    booleans[i]=true;
                    booleans[j]=true;
                    flag = true;
                }
            }
            if (!flag){
                return i;
            }
        }
        if (booleans[booleans.length-1]==true) return booleans.length-1;
        return -1;
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s==null || t==null) return false;
        if (s.length()!=t.length()) return false;
        if (s.isEmpty() && t.isEmpty()) return true;
        char[] chars = s.toLowerCase().toCharArray();
        char[] chart = t.toLowerCase().toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!=chart[i]) return false;
        }
        return true;
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     说明：本题中，我们将空字符串定义为有效的回文串。
     示例 1:
     输入: "A man, a plan, a canal: Panama"
     输出: true
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s==null) return false;
        if (s.isEmpty()) return true;
        char[] chars = s.replaceAll("\\W*","").toLowerCase().toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i]!=chars[chars.length-1-i]) return false;
        }
        return true;
    }
}
