package com.leetcode.otherSet.largestSquares;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/20 10:45
 * @description //1139. 最大的以 1 为边界的正方形
 */
public class Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int ans = grid[0][0];
        int rowLength = grid.length, columnLength = grid[0].length;
        int[][] row = new int[rowLength][columnLength];
        int[][] column = new int[rowLength][columnLength];

        int rowValue, columnValue;
        row[0][0] = grid[0][0];
        column[0][0] = grid[0][0];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (i==0||j==0){
                    if (i==0&&j==0) {}
                    else{
                        if (j==0) {
                            row[i][j] = grid[i][j];
                            if (grid[i][j]==1) {
                                column[i][j] = column[i-1][j] + 1;
                                if (ans==0) ans=1;
                            }
                        }else {
                            column[i][j] = grid[i][j];
                            if (grid[i][j]==1) {
                                row[i][j] = row[i][j-1] + 1;
                                if (ans==0) ans=1;
                            }
                        }
                    }
                }else {
                    if (grid[i][j]==1){
                        rowValue = row[i][j-1]+1;
                        row[i][j] = rowValue;
                        columnValue = column[i-1][j]+1;
                        column[i][j] = columnValue;
                        int value = Math.min(rowValue, columnValue);
                        for (int k = 1; k <= value; k++) {
                            if (column[i][j+1-k]>=k && row[i+1-k][j]>=k){
                                ans = Math.max(k*k, ans);
                            }
                        }

                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Largest1BorderedSquare solver = new Largest1BorderedSquare();
        int[][] input = new int[][]{{0,1,1,1,1,0},{1,1,0,1,1,0},{1,1,0,1,0,1},{1,1,0,1,1,1},{1,1,0,1,1,1},{1,1,1,1,1,1},{1,0,1,1,1,1},{0,0,1,1,1,1},{1,1,1,1,1,1}};
        int ans;
        ans = solver.largest1BorderedSquare(input);
        System.out.println(ans);
    }
}
