package com.leetcode.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/6 11:03
 * @description //TODO
 */
public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        System.out.println(sb.toString());
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());
        Backtracking bp = new Backtracking();
        List<List<Integer>> result = bp.permute(new int[]{1,2,3});
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        backtrack(s, result, new LinkedList<>(), 0, 0);
        return result;
    }

    private void backtrack(String s, List<List<String>> result, List<String> list, int itrCount, int start) {
        if (itrCount==s.length()){
            if (list.size()>0) result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {

        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(result, new LinkedList<Integer>(),nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, LinkedList<Integer> list, int[] nums, int start) {

        result.add(new LinkedList<>(list));
        for (int j = start; j < nums.length; j++) {
            if (j>start && nums[j]==nums[j-1]) continue;
            list.add(nums[j]);
            backtrack(result, list, nums, j+1);
            list.removeLast();
        }
    }


}
