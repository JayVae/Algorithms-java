package com.leetcode.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 19:57 2018/7/12
 * @Modified By:
 */
public class lc438 {
    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if (s==null || s.length()<p.length()) return list;

        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i)-97]++;
        }
        int lo = 0,hi=-1;
        int count = p.length();

        while (hi+1<s.length()){
            if (freq[s.charAt(hi+1)-97]>0){
                hi++;
                freq[s.charAt(hi)-97]--;
                count--;
            }else {
                hi++;
                freq[s.charAt(hi)-97]--;
            }
            if (count==0){
                list.add(lo);
            }
            if (hi-lo+1==p.length() && freq[s.charAt(lo++)-97]++>=0){

                count++;
            }
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        // 输入参数有效性判断
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }

        // 申请一个散列，用于记录窗口中具体元素的个数情况
        // 这里用数组的形式呈现，也可以考虑其他数据结构
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int[] hash = new int[26];

        for (int i = 0; i < pArr.length; ++i) {
            hash[pArr[i] - 'a']++;
        }

        // l 表示左指针
        // count 记录当前的条件，具体根据题目要求来定义
        // result 用来存放结果
        List<Integer> results = new ArrayList<>();
        int l = 0, count = 0, pLength = p.length();

        for (int r = 0; r < sArr.length; ++r) {
            // 更新新元素在散列中的数量
            hash[sArr[r] - 'a']--;

            // 根据窗口的变更结果来改变条件值
            if (hash[sArr[r] - 'a'] >= 0) {
                count++;
            }

            // 如果当前条件不满足，移动左指针直至条件满足为止
            if (r > pLength - 1) {
                hash[sArr[l] - 'a']++;

                if (hash[sArr[l] - 'a'] > 0) {
                    count--;
                }

                l++;
            }

            // 更新结果
            if (count == pLength) {
                results.add(l);
            }
        }

        return results;
    }

    public static void main(String[] args){
        lc438 lc = new lc438();
        List result =  lc.findAnagrams("cbaebabacd","abc");
        int i=0;
        if (true && i++==1){
            System.out.println(i+"     !");
        }
        System.out.println(i);
        int hi=5,lo=2;
        System.out.println((hi++)*(hi-lo));
        hi=5;
        lo=2;
        System.out.println((hi-lo)*(hi++));
        System.out.println(lo+"*******");
        int x = lo+lo++;
        System.out.println(x);
        lo=2;
        x=lo+++lo;
        System.out.println(x);
    }
}
