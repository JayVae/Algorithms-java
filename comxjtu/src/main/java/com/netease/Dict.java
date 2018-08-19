package com.netease;

import java.util.Scanner;

/**
 * @Author: Jay
 * @Date: Created in 17:00 2018/8/14
 * @Modified By:
 */
public class Dict {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int max = permutate(n+m)/(permutate(m)*permutate(n));
        if (k>max){
            System.out.println(-1);
            return;
        }else {
            
        }
    }

    static int permutate(int n){
        if (n==1) return 1;
        return n*permutate(n-1);
    }
}
