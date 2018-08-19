package com.netease;

import java.util.Scanner;

/**
 * @Author: Jay
 * @Date: Created in 16:26 2018/8/14
 * @Modified By:
 */
public class Max {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = a+b+c;
        if (max<(a+b)*c){
            max = (a+b)*c;
        }
        if (max<(a*b)+c){
            max = (a*b)+c;
        }
        if (max<(a*b)*c){
            max = (a*b)*c;
        }
        if (max<a+(b*c)){
            max = a+(b*c);
        }
        if (max<a*(b+c)){
            max = a*(b+c);
        }
        System.out.println(max);
    }
}
