package com.xjtu;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 19:22 2018/5/24
 * @Modified By:
 */
public class Test {

    public static void main(String[] args) {
        Integer i = 3;
        int[][] x[];
        List<Double> ans = new LinkedList<>();
        if (ans.contains(0.0));
        ans.size();
        if (ans.isEmpty()){}
        String s= "abcdef";
        String ss=s.substring(0,2);
        System.out.println(s);
        System.out.println(ss);
        System.out.println("***********************");
        System.out.println('A' - 0);
        System.out.println('Z' - 0);
        byte b = (byte) 130;
        System.out.println(b);
        byte b1 = 3;
        byte b2 = 4;
        byte b3 = (byte) (b1+b2);
        System.out.println(b3);
        test();
        System.out.println(333);
        int offset = (8 & 1)^1;
        System.out.println(offset);
        offset = (7&1)^1;
        System.out.println(offset);
    }

    public static void test(){
        try {
            System.out.println(111);
            return;
        }catch (Exception e){

        }finally {
            System.out.println(222);
        }
    }

}
