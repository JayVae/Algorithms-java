package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/23 11:18
 * @description //子岛屿的数目
 */
public class CountSubIslands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n=grid1[0].length;
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j]==1){
                    if(dfs(grid1, grid2, i, j)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    boolean dfs(int[][] grid, int[][] grid2,int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid2[r][c] == 0) {
            return true;
        }

        grid2[r][c] = 0;
        boolean flag = true;
        if(grid[r][c] == 0){
            // ⭐这里不能直接返回false，否则后面的dfs递归代码就不再执行了
            flag = false;
            return false;
        }
        boolean flag1=dfs(grid, grid2,r - 1, c);
        boolean flag2=dfs(grid, grid2,r + 1, c);
        boolean flag3=dfs(grid, grid2,r, c - 1);
        boolean flag4=dfs(grid, grid2,r, c + 1);

        return flag&&flag1&&flag2&&flag3&&flag4;
    }

}
