package com.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.binarySearch;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/20 10:31
 * @description //436. 寻找右区间
 */
public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length<2) return new int[]{-1};
        int[] ans = new int[intervals.length];
        int[] indexArray = new int[intervals.length];
        Arrays.fill(ans, -1);
        Arrays.sort(indexArray);
        Map<Integer, Integer> indexMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            indexMap.put(intervals[i][0], i);
            indexArray[i] = intervals[i][0];
        }
        Arrays.sort(indexArray);
        for (int i = 0; i < intervals.length; i++) {
            int index = rank(indexArray, intervals[i][1]);
            if (index<indexArray.length){
                ans[i]=indexMap.get(indexArray[index]);
            }
        }
        return ans;

    }

    public int rank(int[] a,int t){
        int lo = 0, hi = a.length-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (a[mid]>t) hi = mid - 1;
            else if (a[mid]<t) lo = mid +1;
            else  return mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        FindRightInterval zhixing = new FindRightInterval();
        int[] test = new int[]{1,2,3};
        System.out.println(zhixing.rank(test, 3));
        System.out.println(zhixing.rank(test, 1));
        System.out.println(zhixing.rank(test, 2));
        System.out.println(zhixing.rank(test, 0));
        System.out.println(zhixing.rank(test, 4));
        int[] ans = zhixing.findRightInterval(new int[][]{{3,4},{2,3},{1,2}});
        System.out.println(Arrays.toString(ans));
    }
}
