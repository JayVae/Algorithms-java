package com.leetcode.otherSet.pointer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/29 16:42
 * @description //双指针专题
 */
public class pointer2 {

    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch>='A' && ch<='Z'){
                sb.append((char)( ch+32));
            }else if ((ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                sb.append(ch);
            }
        }
        String ss = sb.toString();
        n = ss.length();
        for (int i = 0; i < n/2; i++) {
            if (ss.charAt(i) != ss.charAt(n-1-i)) return false;
        }

        return true;
    }

/*
* 392. 判断子序列
* 双指针
* */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
/*
* 167. 两数之和 II - 输入有序数组
* */
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;
        int l = 0, r = n-1;
        int[] ans = new int[2];
        while (l<r){
            if (numbers[l]+numbers[r]==target) {
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            }else if (numbers[l]+numbers[r]>target) r--;
            else l++;
        }
        return ans;
    }
/*
* 11. 盛最多水的容器
* 从两边，往中间缩小，哪边低移动哪边，也就是每次都去短板那边看看有没有更优的结果
* */
public int maxArea(int[] height) {
    int l = 0, r = height.length - 1;
    int ans = 0;
    while (l < r) {
        int area = Math.min(height[l], height[r]) * (r - l);
        ans = Math.max(ans, area);
        if (height[l] <= height[r]) {
            ++l;
        }
        else {
            --r;
        }
    }
    return ans;
}
/*
* 15. 三数之和
* */
public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList();
    int len = nums.length;
    if(nums == null || len < 3) return ans;
    Arrays.sort(nums); // 排序
    for (int i = 0; i < len ; i++) {
        if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
        if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
        int L = i+1;
        int R = len-1;
        while(L < R){
            int sum = nums[i] + nums[L] + nums[R];
            if(sum == 0){
                ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                while (L<R && nums[L] == nums[L+1]) L++; // 去重
                while (L<R && nums[R] == nums[R-1]) R--; // 去重
                L++;
                R--;
            }
            else if (sum < 0) L++;
            else if (sum > 0) R--;
        }
    }
    return ans;
}
    public static void main(String[] args) {
//        test
        pointer2 pointer2 = new pointer2();
//"A man, a plan, a canal: Panama"
        String s = "A man, a plan, a canal: Panama";
//        System.out.println(pointer2.isPalindrome(s));
        int[] num = new int[]{1,1};
        System.out.println(pointer2.maxArea(num));
    }
}
