package com.leetcode.otherSet.huadong;


import java.util.*;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/30 10:30
 * @description //面试经典150题 滑动窗口专题
 */
public class HuaDong {

    /*
    *209. 长度最小的子数组
    *
    * */
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int ans = n+1;
        int l = 0, r = 0;
        int sum = nums[0];
        while (r<n&&l<n){
            if (sum>=target) {
                ans = Math.min(r-l+1, ans);
                sum -= nums[l];
                l++;
            }else {
                r++;
                if (r<n) sum += nums[r];
            }
        }
        return ans==n+1 ? 0 : ans;
    }
    /*
    * 3. 无重复字符的最长子串
    * */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n<2) return n;
        int ans = 1;
        int l=0,r=0;
        Set<Character> set = new HashSet<>();

        while (r<n){
            while (r<n && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            ans = Math.max(ans, r-l);
        }
        return ans;
    }


    /*
    * 30. 串联所有单词的子串
    * */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
/*
* 76. 最小覆盖子串
* */
Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HuaDong huaDong = new HuaDong();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
//        System.out.println(huaDong.minSubArrayLen(target, nums));
        String s= "pwwkew";
        System.out.println(huaDong.lengthOfLongestSubstring(s));
    }
}
