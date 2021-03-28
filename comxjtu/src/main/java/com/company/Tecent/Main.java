package com.company.Tecent;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int k = in.nextInt();
            int a = in.nextInt();
            int x = in.nextInt();
            int b = in.nextInt();
            int y = in.nextInt();
            int cnt = 0;
            for (int i = 0; i <= k/a || i<=x; i++) {
                int yc = (k-i*a)/b;
                if ((k-i*a)%b==0 && yc<=y){
                    cnt = cnt + Cmn(x,i)*Cmn(y,yc);
                    System.out.println(i+","+yc);
                    System.out.println(Cmn(x,i));
                    System.out.println(Cmn(y,yc));
                    if (cnt>=1000000007){
                        cnt=cnt%1000000007;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static int Cmn(int m, int n){
        return Up(m,n)/Down(n);
    }

    private static int Down(int n) {
        if (n==0) return 1;
        return n*Down(n-1);
    }

    private static int Up(int m, int n) {
        if (n==0) return m;
        return Up(m,n-1)*(m-n);
    }

}