package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 15:42 2018/5/29
 * @Modified By:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 例如:
 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 注意：
 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 我们可以不考虑输出结果的顺序。

 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null) return null;
        if (nums1.length==0) return nums1;
        else if (nums2.length==0) return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int min = nums1[0],max = nums1[nums1.length-1];
        int shift = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i]>max) break;
            if (nums2[i]>=min && nums2[i]<=max){
//                int loc = binarySearch(nums1,nums2[i],shift);
//                if (loc!=-1){
//                    if(loc>0 && nums1[loc]==nums1[loc-1]) loc--;
//                    if(loc>0 && nums1[loc]==nums1[loc+1]) loc--;
//                    shift = loc+1;
//                    list.add(nums2[i]);
//                }
                for (int j = 0+shift; j < nums1.length; j++) {
                    if (nums2[i]==nums1[j]){
                        list.add(nums2[i]);
                        shift=j+1;
                        break;
                    }
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int binarySearch(int[] nums, int target,int loc){
        int lo = loc, hi=nums.length-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if (nums[mid]<target) lo=mid+1;
            else if (nums[mid]>target) hi=mid-1;
            else return mid;
        }
        return -1;
    }
}
