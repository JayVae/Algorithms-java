package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/7 10:45
 * @description //1040. 移动石子直到连续 II
 */
public class NumMoveStonesII {

    public int[] numMovesStonesII(int[] stones) {
        int[] ans = new int[2];
        int len = stones.length;
        int[] space = new int[len-1];
        int minCount = 0, maxCount = 0;

        Arrays.sort(stones);
        while (stones[len-1]-stones[0]>len-1){
//            int[] maxValueandIndex = getMaxValueandIndex(space);
//            int[] minValueandIndex = getMinValueandIndex(space);
            int min=stones[len-1], max=-1, maxIndex=-1, minIndex=-1;
            for (int i = 1; i < stones.length; i++) {
                space[i-1] = stones[i]-stones[i-1];
                if (space[i-1]>max){
                    max = space[i-1];
                    maxIndex = i-1;
                } else if (space[i - 1] < min) {
                    min = space[i-1];
                    minIndex = i-1;
                }
            }

            if (space[0]==1){
                update(stones, max, maxIndex);
                minCount++;
            }else if (space[len-2]==1){

            }else {

            }
            Arrays.sort(stones);
        }



        return ans;
    }

    private void update(int[] stones, int max, int maxIndex) {
    }
}
