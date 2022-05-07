package com.leetcode.tmp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/7 16:46
 * @description //TODO
 */
public class test {

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                count++;
            }else {
                nums[i-count] = nums[i];
            }
        }
        for (int i = nums.length-count; i < nums.length; i++) {
            nums[i]=0;
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        recursion(result, numRows);
        return result;
    }

    private List<Integer> recursion(List<List<Integer>> result, int numRows) {
        if (numRows==2){
            List<Integer> list1 = new LinkedList<>();
            list1.add(1);
            result.add(list1);
            List<Integer> list2 = new LinkedList<>(list1);
            list2.add(1);
            result.add(list2);
            return list2;
        }
        if (numRows==1){
            List<Integer> list1 = new LinkedList<>();
            list1.add(1);
            result.add(list1);
            return list1;
        }

        List<Integer> pre = recursion(result, numRows-1);
        List<Integer> list = new LinkedList<>();
        list.add(1);
        for (int j = 0; j < pre.size()-1; j++) {
            list.add(pre.get(j)+pre.get(j+1));
        }
        list.add(1);
        result.add(list);
        return list;

    }


    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        result.add(list1);
        if (numRows<2) return result;
        List<Integer> list2 = new LinkedList<>(list1);
        list2.add(1);
        result.add(list2);
        List<Integer> pre = list2;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(1);
            for (int j = 0; j < pre.size()-1; j++) {
                list.add(pre.get(j)+pre.get(j+1));
            }
            list.add(1);
            result.add(list);
            pre = list;
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        if (rowIndex+1==1) return list;
        list.add(1);
        if (rowIndex+1==2) return list;
        List<Integer> pre = list;
        for (int i = 3; i <= rowIndex+1; i++) {
            List<Integer> now = new LinkedList<>();
            now.add(1);
            for (int j = 0; j < pre.size()-1; j++) {
                now.add(pre.get(j)+pre.get(j+1));
            }
            now.add(1);
            pre = now;
        }
        return pre;

    }

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            for (int j = 0; j < chars.length/2; j++) {
                char tmp = chars[chars.length-1-j];
                chars[chars.length-1-j] = chars[j];
                chars[j] = tmp;
            }
            sb.append(String.valueOf(chars));
            if (i<strings.length-1) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "2";
        System.out.println(Arrays.toString(s.split(" ")));
        System.out.println();
    }
}
