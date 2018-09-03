package com.xjtu;

/**
 * @Author: Jay
 * @Date: Created in 19:22 2018/5/24
 * @Modified By:
 */
public class Test {

    public static void main(String[] args) {
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
