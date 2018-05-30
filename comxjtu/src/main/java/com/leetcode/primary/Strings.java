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

    /**
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str==null || str.isEmpty()) return 0;
        String strr = str.trim();
        if (strr.length()==0 ) return 0;
        if (strr.charAt(0)=='-'){
            if (strr.length()==1) return 0;
            if (strr.charAt(1)>=48 && strr.charAt(1)< 58){
                strr = strr.substring(1).replaceAll("\\D+","A");
                if (strr.contains("A")){
                    strr = strr.substring(0,strr.indexOf('A'));
                }else {

                }
                strr = "-"+strr;
                int ans = Integer.MIN_VALUE;
                try {
                    ans = Integer.valueOf(strr);
                }catch (Exception e){
                    ans = Integer.MIN_VALUE;
                    return ans;
                }
                return ans;
            }
        }else if (strr.charAt(0)>=48 && strr.charAt(0)< 58){
            strr = strr.replaceAll("\\D+","A");
            if (strr.contains("A")){
                strr = strr.substring(0,strr.indexOf('A'));
            }else {

            }
            int ans = Integer.MAX_VALUE;
            try {
                ans = Integer.valueOf(strr);
            }catch (Exception e){
                ans = Integer.MAX_VALUE;
                return ans;
            }
            return ans;
        }else if(strr.charAt(0)=='+'){
            if (strr.length()==1) return 0;
            if (strr.charAt(1)>=48 && strr.charAt(1)< 58){
                strr = strr.substring(1).replaceAll("\\D+","A");
                if (strr.contains("A")){
                    strr = strr.substring(0,strr.indexOf('A'));
                }else {

                }
                int ans = Integer.MAX_VALUE;
                try {
                    ans = Integer.valueOf(strr);
                }catch (Exception e){
                    ans = Integer.MAX_VALUE;
                    return ans;
                }
                return ans;
            }
        } else {
            return 0;
        }
        return 0;
    }

    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack==null || needle==null) return -1;
        if (haystack.isEmpty() && !needle.isEmpty()) return -1;
        if (needle.isEmpty()) return 0;
        if (haystack.length()<needle.length()) return -1;
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int ans = -1;
        int j=0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i]==chars2[j]){
                if (j==0) ans=i;
                j++;
                if (j==chars2.length) return ans;
            }else {
                if (ans!=-1) i=ans;
                j=0;
                ans=-1;
            }
        }
        return -1;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return "";
        if (strs.length==1) return strs[0];
        String cmp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            cmp = longgestCommonP(cmp,strs[i]);
        }
        return cmp;
    }
    private String longgestCommonP(String s1, String s2){
        int len = s1.length()>s2.length()? s2.length():s1.length();
        StringBuffer sb = new StringBuffer();
        sb.append("");
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else {
                break;
            }
        }
        return sb.toString();
    }
}
