package com.xjtu;

import java.util.Arrays;

/**
 * @Author: Jay
 * @Date: Created in 19:22 2018/5/24
 * @Modified By:
 */
public class Test {

    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "abc";
        Integer n1 = 10;
        Integer n2 = 10;
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode()==s2.hashCode());

        System.out.println("abc".hashCode()=="abc".hashCode());
        System.out.println(n1.equals(n2));
        System.out.println(n1.hashCode()==n2.hashCode());
        int[] arr = new int[]{1,2,3};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            
        }
    }

}
