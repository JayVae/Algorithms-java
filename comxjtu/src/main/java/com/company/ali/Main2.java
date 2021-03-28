package com.company.ali;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int x = input.nextInt();
            int y = input.nextInt();
            String str = input.nextLine();
            char[] chars = str.toCharArray();
            int[] nums = new int[chars.length];
            //其实方法只要求出（x,y）与多边形每两个相邻点之间的夹角即可，如果所有夹角之和不等于360，则输出no
//            而三个点可以得到三条边的大小，运用余弦定理，计算出夹角。
            for (int i = 0; i < chars.length; i++) {
                nums[i]=Integer.valueOf(chars[i]);
            }
            for (int i = 0; i < nums.length / 2-1; i++) {

            }
            System.out.println("yes,"+0);
        }
    }

}
