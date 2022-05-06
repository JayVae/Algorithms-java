package com.leetcode.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/5 22:16
 * @description //290场周赛 华为
 */
public class Week290HW {

    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        // 初始哈希表
        int[] counts = new int[1001];
        List<Integer> list = new ArrayList<>();
        for (int number[]:nums) {
            for (int x: number) {
                counts[x]++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            // 次数等于数组个数
            if (counts[i] == n) list.add(i);
        }
        // 排序
        Collections.sort(list);
        return list;
    }

    public int countLatticePoints(int[][] circles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
        for (int[] c : circles) {
            minX = Math.min(minX, c[0] - c[2]);
            minY = Math.min(minY, c[1] - c[2]);
            maxX = Math.max(maxX, c[0] + c[2]);
            maxY = Math.max(maxY, c[1] + c[2]);
        }
        int cnt = 0;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                for (int[] c : circles) {
                    int dis = (i - c[0]) * (i - c[0]) + (j - c[1]) * (j - c[1]);
                    if (dis <= c[2] * c[2]) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}
