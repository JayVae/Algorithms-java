package com.HW;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int nums = in.nextInt();
            double price = in.nextDouble();
            System.out.println(getAnswer(nums,price));
        }
    }

    private static int getAnswer(int nums,double price){
        double A = 0;
        double B = 0;
        if (nums>=3){
            A = 0.7*nums*price+10;
            if (A>=50){
                A -= 10;
            }
        }
        B = nums* price+6;
        if (B>=10){
            int cnt = (int)B/10;
            B -= 2*cnt;
        }
        if (B>=99) B -= 6;

        if (A>B){
            return 2;
        }else if(A<B){
            return 1;
        }else {
            return 0;
        }
    }
}
