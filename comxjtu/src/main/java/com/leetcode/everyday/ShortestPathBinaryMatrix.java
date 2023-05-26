package com.leetcode.everyday;

import java.util.*;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/26 8:51
 * @description //1091. 二进制矩阵中的最短路径
 */
public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }

        int[][] dirs = new int[][]{{-1,-1}, {-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{0, 0});
        visited.add(0);
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {//BFS中一次处理当前队列的所有元素
                int[] cur = queue.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1) {//到达终点
                    return ans;
                }
                for (int[] dir : dirs) {//遍历八个方向的邻居
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    int pos = x * n + y;
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1 || visited.contains(pos)) {
                        continue;
                    }
                    queue.offer(new int[]{x, y});
                    visited.add(pos);
                }
            }
            ans++;
        }
        return -1;//无法到达终点
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix solver = new ShortestPathBinaryMatrix();
//        [[0,1,1,0,0,0],[0,1,0,1,1,0],[0,1,1,0,1,0],[0,0,0,1,1,0],[1,1,1,1,1,0],[1,1,1,1,1,0]]
        int[][] grid = new int[][]{{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}};
        System.out.println(solver.shortestPathBinaryMatrix(grid));
    }
}
