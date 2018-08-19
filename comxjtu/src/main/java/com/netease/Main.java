package com.netease;

import java.util.Scanner;

/**
 * @Author: Jay
 * @Date: Created in 14:46 2018/8/12
 * @Modified By:
 */
public class Main {

    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr= new int[n];
        int cnt = 0, res=0;
        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt()-1;
            if (arr[tmp]==0){
                cnt++;
            }
            arr[tmp]++;
            if (cnt==n){
                res++;
                for (int j = 0; j < n; j++) {
                    arr[j]--;
                    if (arr[j]==0){
                        cnt--;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
