package com.netease;

import java.util.Scanner;

/**
 * @Author: Jay
 * @Date: Created in 15:54 2018/8/14
 * @Modified By:
 */
public class Nod {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] score = new int[n];
        int[] ones = new int[n];
        int sum = 0,max = 0;
        for (int i = 0; i < n; i++) {
            score[i]= sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ones[i]= sc.nextInt();
            if (ones[i]==1){
                sum += score[i];
            }
        }
        for (int i = 0; i < n - k; i++) {
            if (ones[i]==0){
                int tmp = 0;
                for (int j = i; j < i+k; j++) {
                    if (ones[j]==0){
                        tmp += score[j];
                    }
                }
                if (tmp>max){
                    max = tmp;
                }
            }
        }
        System.out.println(sum+max);
    }
}
