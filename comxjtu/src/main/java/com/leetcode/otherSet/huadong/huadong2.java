package com.leetcode.otherSet.huadong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/13 11:13
 * @description //TODO
 */
public class huadong2 {

    public int minSubArrayLen(int target, int[] nums) {
        int n= nums.length;
        int left = 0, right = 0;
        int sum =0;
        int ans = 100001;
        while (right<n){
//            处理当前窗口
            sum += nums[right];
//            缩小窗口
            while (sum>=target){
                ans = Math.min(right-left+1, ans);
                sum -= nums[left];
                left++;
            }
//            增大窗口
            right++;

        }
        return ans == 100001 ? 0 : ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int ans = 0;
//        判断窗口有效性需要的数据结构
        Map<Character, Integer> map = new HashMap<>();

        while (right<n){
//            处理当前窗口
            Character ch = s.charAt(right);
//            收缩窗口
            while (left<right && map.containsKey(ch)){
                map.remove(s.charAt(left));
                left++;
            }
            map.put(ch, right);
            ans = Math.max(ans, right-left+1);
//            扩展窗口
            right++;

        }
        return ans;
    }

    /*
    * todo
    * */
    public List<Integer> findAnagrams(String s, String p) {

    }

    public static void main(String[] args) {
        huadong2 solver = new huadong2();
        System.out.println(solver.lengthOfLongestSubstring("abba"));
    }
}
