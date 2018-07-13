package com.leetcode.Question;

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
