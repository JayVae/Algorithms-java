package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/11 10:55
 * @description //1041. 困于环中的机器人
 */
public class isRobotBounded {

    public boolean isRobotBounded(String instructions) {
        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direcIndex = 0;
        int x = 0, y = 0;
        int n = instructions.length();
        for (int idx = 0; idx < n; idx++) {
            char instruction = instructions.charAt(idx);
            if (instruction == 'G') {
                x += direc[direcIndex][0];
                y += direc[direcIndex][1];
            } else if (instruction == 'L') {
                direcIndex += 3;
                direcIndex %= 4;
            } else {
                direcIndex++;
                direcIndex %= 4;
            }
        }
        return direcIndex != 0 || (x == 0 && y == 0);
    }
}
