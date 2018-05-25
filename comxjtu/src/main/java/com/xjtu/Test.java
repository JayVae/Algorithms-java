package com.xjtu;

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

//        int a =9646324351;
        String str = "-123456";
        System.out.println(str);
        char[] chr = str.toCharArray();
        System.out.print(chr[0]);
        for (int i = 0; i < chr.length; i++) {
            System.out.print(chr[chr.length-i-1]);
        }
        System.out.println();
        if (chr[0]=='-'){
            for (int i = 1; i < chr.length/2+1; i++) {
                char tmp = chr[i];
                chr[i] = chr[chr.length-i];
                chr[chr.length-i] = tmp;
            }
        }else {
            for (int i = 0; i < chr.length / 2; i++) {
                char tmp = chr[i];
                chr[i] = chr[chr.length-1-i];
                chr[chr.length-1-i] = tmp;
            }
        }
        int a=0;
        try{
            a = Integer.valueOf(String.valueOf(chr));
        }catch (Exception e){
            System.out.println(0);
        }
        System.out.println(a);

    }

}
