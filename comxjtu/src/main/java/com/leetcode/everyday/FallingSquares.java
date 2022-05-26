package com.leetcode.everyday;

import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/26 19:55
 * @description //699. 掉落的方块
 */
public class FallingSquares {
//    内存超过限制而且，以下这种方法对这个案例是错的：
//输入：
//[[2,1],[2,9],[1,8]]
//输出：
//[1,9,17]
//预期结果：
//[1,10,18]
    int MAX_COUNT = 100000001;
    public List<Integer> fallingSquares(int[][] positions) {
        int[] lowArray = new int[MAX_COUNT];
        int[] highArray = new int[MAX_COUNT];
        List<Integer> ans = new LinkedList<>();
        int max=0;
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int side = positions[i][1];
            int right = left + side;
            int base = lowArray[left];
            for (int j = left; j < right+1; j++) {
                base = Math.max(base, lowArray[j]);
            }
            for (int j = left+1; j < right; j++) {
                highArray[j]=base+side;
                lowArray[j]=base+side;
            }
            lowArray[left]=Math.min(base+side, highArray[left]);
            highArray[left] = Math.max(base+side, highArray[left]);
            lowArray[right]=Math.min(base+side, highArray[right]);
            highArray[right]=Math.max(base+side, highArray[right]);
            max=Math.max(max, base+side);
            ans.add(max);
        }
        return ans;
    }

}
