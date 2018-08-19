package com.netease;

import java.util.Scanner;

/**
 * @Author: Jay
 * @Date: Created in 16:37 2018/8/14
 * @Modified By:
 */
public class Tower {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] height = new int[n];
        int[] left = new int[n];
        int sum = 0,cnt1=0,cnt2=0;
        for (int i = 0; i < n; i++) {
            height[i]= sc.nextInt();
            sum += height[i];
        }
        for (int i = 0; i < n; i++) {
            left[i] = sum/n-height[i];
            if (left[i]>0){
                cnt1 += left[i];
            }
            if (left[i]<0){
                cnt2 += 0-left[i];
            }
        }
        if (Math.min(cnt1,cnt2)>k){

        }else {

        }


    }
}
