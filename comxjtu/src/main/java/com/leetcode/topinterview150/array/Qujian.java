package com.leetcode.topinterview150.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/10 19:13
 * @description //区间问题
 * 一般用双指针
 */
public class Qujian {

    /*
    * 228. 汇总区间
    * 已知有序，求连续的区间。
    * */
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
    /*
    * 56. 合并区间
    * */
    public int[][] merge(int[][] intervals) {
        List<int[]> ansList = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        for (int i = 0; i < intervals.length;) {
            int left = i;
            int maxRight = intervals[i][1];
            i++;
            while (i<intervals.length && intervals[i][0]<=maxRight){
                maxRight = Math.max(maxRight,intervals[i][1]);
                i++;
            }
            ansList.add(new int[]{intervals[left][0], maxRight});
        }
        return  ansList.toArray(new int[ansList.size()][]);
    }

    /*
    * 57. 插入区间
    * 基本同上，需要先添加一个二分查找，将newInterval添加到有序数组中，然后再合并。
    * 这里用直接合并的方法，即从前往后判断
     * */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
    /*
    * 452. 用最少数量的箭引爆气球
    * 同样，对能合并的区间进行合并，得到交集，如果交集只剩一个点（即left=right），则不能再合并
     * */
    public int findMinArrowShots(int[][] points) {
//        如果写为Arrays.sort(points, (a, b)-> a[0]-b[0])时[[-2147483646,-2147483645],[2147483646,2147483647]]会出错
        Arrays.sort(points, (a, b)-> a[0]<b[0] ? -1 : 1);
        int ans = 0;
        for (int i = 0; i < points.length;) {
            int left = points[i][0];
            int right = points[i][1];
            i++;
            while (i<points.length && points[i][0]<=right){
                left = Math.max(left,points[i][0]);
                right = Math.min(points[i][1], right);
                i++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{15,18},{8,10},{7,11}};
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        Qujian qujian = new Qujian();
        int[][] ans = qujian.merge(intervals);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
        System.out.println("----------");
        System.out.println(qujian.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));

    }
}

