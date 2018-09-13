package com.java;

import java.util.HashSet;

/**
 * @Author: Jay
 * @Date: Created in 16:30 2018/9/13
 * @Modified By:
 */
public class Hash {

    public static void main(String[] args) {
        String a1=new String("张");
        String a2=new String("张");
        String a3=new String("吴");
        HashSet<String> h1=new HashSet<>();
        h1.add(a1);
        h1.add(a2);
        h1.add(a3);
        System.out.println(h1);
    }
}
