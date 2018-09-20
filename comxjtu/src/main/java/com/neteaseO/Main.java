package com.neteaseO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            System.out.println(minDistance(s1,s2));
        }
    }

    private static int minDistance(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 == 0){
            return l2;
        }else if (l2 == 0){
            return l1;
        }
        int min = 0;
        int[][] dp = new int[l1+1][l2+1];

        for (int i = 0; i < l1+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < l2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    if (dp[i-1][j-1]+1<Math.min(dp[i-1][j]+1,dp[i][j-1]+1)){
                        dp[i][j] = dp[i-1][j-1]+2;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                    }
                }
            }
        }
        min = dp[l1][l2];
        return min;
    }


}
