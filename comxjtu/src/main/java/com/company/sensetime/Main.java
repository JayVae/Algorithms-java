package com.company.sensetime;

import java.util.Scanner;

/**
 * @Author: Jay
 * @Date: Created in 19:25 2018/9/26
 * @Modified By:
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = in.nextInt();
                }
            }
            int i = n-1,j=m-1;
            while (i>0 && j>0){
                if (nums[i-1][j]!=-1){
                    nums[i-1][j] = nums[i-1][j]+nums[i][j];
                }else {
                }
            }
        }
    }
}
