package com.company.N360;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int maxX=0,maxY=0,minX=0,minY=0;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                if (x<minX){
                    minX = x;
                }else if (x>maxX){
                    maxX = x;
                }
                if (y<minY){
                    minY = y;
                }else if (y>maxY){
                    maxY = y;
                }
            }
//            BigInteger ans = BigInteger.valueOf(Math.max((maxX-minX),(maxY-minY)));
//            System.out.println(ans.multiply(ans));
            BigDecimal ans = BigDecimal.valueOf(Math.max((maxX-minX),(maxY-minY)));
            System.out.println(ans.multiply(ans));
        }
    }
}
