package com.leetcode.Question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 17:28 2018/5/25
 * @Modified By:
 */

/**
 * 用的是排序加二分查找；
 * 但是：时间太长。
 * 这个方法关键在于怎么样检测是否有重复的
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        int loc0 = rank(nums,0);
        System.out.println(loc0);
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                int loc = j;
//                int loch = nums.length-1;
                if ((-nums[i]-nums[j])>=0) loc=loc0;
                boolean flag = binarySearch(nums,-nums[i]-nums[j],Math.max(loc,j));
                if (flag){
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i]-nums[j]);
                    boolean f=true;
                    if (ans.isEmpty()) {
                        ans.add(list);
                    }else {
                        for (List l : ans) {
                            if (l.containsAll(list)&& list.containsAll(l)){
                                f=false;
                                break;
                            }
                        }
                        if (f){
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public boolean binarySearch(int[] arr,int s,int k){
        int lo=k+1,hi=arr.length-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (s>arr[mid]) lo=mid+1;
            else if (s<arr[mid]) hi=mid-1;
            else return true;
        }
        return false;
    }

    public int rank(int[] arr,int s){
        int lo=0,hi=arr.length-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (s>arr[mid]) lo=mid+1;
            else if (s<arr[mid]) hi=mid-1;
            else return mid;
        }
        return lo;
    }

}
