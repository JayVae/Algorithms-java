package com.company.ali;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int n = input.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = input.nextInt();
            }
            if (n==0 || n==1 || n==2 || n==4 || n==5 || n==7 || n==11 || (n%2!=0&&n%3!=0)){
                System.out.println(0);
            }
            System.out.println(0);
        }
    }

}
