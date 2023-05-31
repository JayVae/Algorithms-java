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
        int sLength = s.length(), wLength = words[0].length();
        int n = words.length;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {

        }


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
