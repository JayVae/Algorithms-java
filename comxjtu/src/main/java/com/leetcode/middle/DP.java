package com.leetcode.middle;

/**
 * @Author: Jay
 * @Date: Created in 17:50 2018/6/9
 * @Modified By:
 */
public class DP {

    public boolean canJump(int[] nums) {
        if (nums.length<2) return true;
        int n = nums.length-1;
        while(n>0){
            boolean flag = false;
            int max=0;
            for (int i = n-1; i >=0; i--) {
                if (i==0){
                    if (n-i<=nums[i]){
                        flag = true;
                        max = i;
                    }
                }else if (n-i<=nums[i]){
                    flag = true;
                    max = i;
                }
            }
            if (flag){
                n=max;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     1
     其实就是个高中的组合数学的问题。
     　　m*n的棋盘，一共需要走(m-1)+(n-1)步，向右走m-1步，向下走n-1步，这(m-1)+(n-1)步中，只要确定了哪些步向右，即同时确定了哪些步向下走，反之亦然。
     　　答案即C(m+n-2,m-1)或C(m+n-2,n-1)
     2
     采用动态规划。
     对于格点(i,j)。由于只能从上格点(i-1,j)或左格点(i,j-1)到达，并且两者路径是不重复的
     因此path[i][j] = path[i-1][j]+path[i][j-1]

     int[][] ways = new int[m][n];
     for (int i = 0; i < m; i++) {
     for (int j = 0; j < n; j++) {
     if (i == 0 || j == 0) ways[i][j] = 1;
     else ways[i][j] = ways[i-1][j] + ways[i][j-1];
     }
     }
     return ways[m-1][n-1];

     **/
    public int uniquePaths(int m, int n) {
        double res = 1;
        for (int i = 1; i <= n - 1; i++)
            res *= ((double) (m + i - 1) / (double) i);
        return (int) Math.round(res);

    }

    private static int[][] result;

    private static int maxValue = 100000000;
    public int search(int index, int amount, int[] coins){
        if(index >= coins.length){
            return maxValue;
        }

        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return maxValue;
        }

        if(result[index][amount] >= 0){
            return result[index][amount];
        }

        result[index][amount] = Math.min(search(index, amount - coins[index], coins) + 1,
                search(index + 1, amount, coins));
        return result[index][amount];
    }

    public int coinChange(int[] coins, int amount) {
        result = new int[20][10000];
        for(int i = 0;i < 20; i++){
            for(int j = 0; j < 10000; j++){
                result[i][j] = -1;
            }
        }

        int val = search(0, amount, coins);
        if(val < maxValue){
            return val;
        }else{
            return -1;
        }
    }
}

