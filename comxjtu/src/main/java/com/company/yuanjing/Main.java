package com.company.yuanjing;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]+"");
            }
            System.out.println("");
        }
    }
}
