package com.company.N360;

import java.util.Scanner;

/**
 * @Author: Jay
 * @Date: Created in 10:39 2018/8/27
 * @Modified By:
 */
public class DivideGold {

    public static void main(String[] args) {
        int t;//测试数据组数.
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for (int k = 1; k <= t; k++) {
            int n;
            n = in.nextInt();
            int[][] dp = new int[n+1][n+1];//dp[x][y]保存第x堆到第y堆的最优解
            int[] a = new int[n+1];//每堆金矿含金量.
            int[] sum = new int[n+1];//n堆金矿总含金量.
            for (int j = 1; j <= n; j++) {
                a[j] = in.nextInt();
                sum[j] = sum[j-1] + a[j];
                dp[j][j] = a[j];
            }

            for (int i = 1; i < n; i++) {//外层循环控制
                for (int j = 1; j+i <= n; j++) {
                    int t_sum = sum[i+j] - sum[j-1];//j1到j1+i1堆的总含金量
                    int min_gold = Math.min(dp[j+1][i+j], dp[j][i+j-1]);//得到取最左端或者最右端的最小含金量
                    dp[j][j+i] = t_sum-min_gold;//总含金量-最小含金量=最大剩余含金量
                }
            }
            System.out.println("Case #"+k+": "+dp[1][n]+" "+(sum[n]-dp[1][n]));
        }
    }
}
