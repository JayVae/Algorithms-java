package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 20:40 2018/6/13
 * @Modified By:
 */
public class Backpacking {
    /**
     * 电话号码的字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.length()==0) return result;
        String[] dict = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String first = dict[(int)digits.charAt(0)-2-48];
        for (int i = 0; i < first.length(); i++) {
            result.add(first.charAt(i)+"");
        }
        for (int i = 1; i < digits.length(); i++) {
            int len = result.size();
            for (int j = 0; j < len; j++) {
                String tmp = result.remove(0);
                String now = dict[(int)digits.charAt(i)-2-48];
                for (int k = 0; k < now.length(); k++) {
                    result.add(tmp+now.charAt(k));
                }
            }
        }
        return result;
    }

    /**
     * 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    /**
     * 生成括号:给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 思路：
     在构造这个字符串时需要满足左括号的个数不能少于右括号的个数。
     当左括号的个数小于右括号个数时，返回
     当左括号个数和右括号个数均为n时，表示得到一个有效的字符串，将其push到vector中；
     当左括号个数等于n而右括号个数不为n时，在字符串中添加右括号知道右括号个数为n；
     否则随意添加左右括号。
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    /**
     * 子集：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length==0) return result;
        int len = nums.length;
        for (int i = 0; i < Math.pow(2, len); i++) {
            String tmp = Integer.toBinaryString(i);
            List<Integer> list = new LinkedList<>();
//            String ans = "";
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(tmp.length()-1-j)=='1') list.add(nums[j]);
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 子集2：给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args){
        int i=0;
        String tmp = Integer.toBinaryString(i);
        System.out.println(tmp.length());
        String tmp2 = Integer.toBinaryString(7);
        System.out.println(tmp2.length());
        int[] nums = new int[]{1,2,3};
        Backpacking bp = new Backpacking();
        List<List<Integer>> result=bp.subsets(nums);
    }
}
