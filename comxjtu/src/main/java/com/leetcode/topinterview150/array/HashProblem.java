package com.leetcode.topinterview150.array;

import java.util.*;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/10 9:41
 * @description //哈希表相关问题
 */
public class HashProblem {

    /*
    * 383. 赎金信
    * 实际就是magazine包含ransomNote的关系
    * */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            count[ch-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (--count[ch-'a']<0) return false;
        }
        return true;
    }
/*
* 205. 同构字符串
* 相同的模式即可，即ABA这种
* */
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
//        0-255
        int index = 0;
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mapS.containsKey(s.charAt(i)) && mapT.containsKey(t.charAt(i))){
                if (mapS.get(s.charAt(i)) != mapT.get(t.charAt(i))){
                    return false;
                }
            }else if (!mapS.containsKey(s.charAt(i)) && !mapT.containsKey(t.charAt(i))){
                mapS.put(s.charAt(i), index);
                mapT.put(t.charAt(i), index);
                index++;
            }else return false;
        }
        return true;
    }
/*
* 290. 单词规律
* 同上
* */
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        int n = pattern.length();
        if (n!=strings.length) return false;
        Map<Character, String> p2s = new HashMap<>();
        HashMap<String, Character> s2p = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character ch = pattern.charAt(i);
            String s1 = strings[i];
            if ((p2s.containsKey(ch) && !p2s.get(ch).equals(s1))
                    || (s2p.containsKey(s1) && s2p.get(s1)!=ch))
                return false;
            p2s.put(ch, s1);
            s2p.put(s1,ch);
        }
        return true;
    }

    /*
    * 242. 有效的字母异位词
    * 统计两个字符串中字符的种类和次数
    * */
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n!=t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c-'a']--;
        }
        /* 如果两者种类相同且数量相同的话，应该是全0数组 */
        if (Arrays.stream(count).filter(a -> a==0).count()==26)
            return true;
        else return false;
    }
    /*
    * 49. 字母异位词分组
    * 方法一：排序相同即可
    * */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    /*
    * 202. 快乐数
    * 将每一步结果存下来，看是否重复循环
    * */
    public boolean isHappy(int n) {
        Set<Integer> set= new HashSet<>();
        while (n!=1){
            if (set.contains(n)) return false;
            else set.add(n);
//            拆解并计算各位数之和
            n = getSqureSum(n);
        }
        return true;
    }

    private int getSqureSum(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /*
    * 219. 存在重复元素 II
    * 这个滑动窗口写的不太好
    * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while (right<n){
            while (right<n && right-left <= k){
                if (set.contains(nums[right])){
                    return true;
                }else set.add(nums[right]);
                right++;
            }
            set.remove(nums[left]);
            left++;
        }
        return false;
    }
    /*
    * 128. 最长连续序列
    * 用hashset先保存，以供查找方便；对于每一个查找其后续的连续数字；
    * 为确保重复过的不再查找，可以先查找其小于1的。
    * */
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set =  new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num-1)){
                int count = 0;
                while (set.contains(num++)){
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HashProblem hashProblem = new HashProblem();
        System.out.println(hashProblem.wordPattern("abba", "dog cat cat dog"));
        System.out.println(hashProblem.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(Integer.MAX_VALUE);
        int a = 1999999999;
        System.out.println(hashProblem.isHappy(a));
        System.out.println(hashProblem.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
