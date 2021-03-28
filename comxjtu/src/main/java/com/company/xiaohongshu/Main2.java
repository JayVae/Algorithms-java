package com.company.xiaohongshu;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int n = in.nextInt();

            System.out.println(numberOf1(n));
        }
    }

    private static int numberOf1(int n){
        if(n < 0 ){
            return 0;
        }
        int curr, low, temp, high = n, i = 1, total = 0;
        while(high!=0){
            high = n / (int)Math.pow(10, i);
            temp = n % (int)Math.pow(10, i);
            curr = temp / (int)Math.pow(10, i-1);
            low = temp%(int)Math.pow(10, i-1);
            if(curr == 1){
                total += high*(int)Math.pow(10, i-1)+ low + 1;
            }else if(curr < 1){
                total += high*(int) Math.pow(10, i-1);
            }else{
                total += (high + 1) * (int)Math.pow(10, i-1);
            }
            i++;
        }
        return total;
    }
}
