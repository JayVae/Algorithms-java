package com.leetcode.senior;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Jay
 * @Date: Created in 11:03 2018/9/14
 * @Modified By:
 */
public class Backpack {

    public static void main(String[] args){

        char mychar = 'g';
        String mystr = String.valueOf(mychar);
        System.out.println("Strin +"+mystr);
        List<String> aa = new ArrayList<>();
        aa.add("F1");
        aa.add("F2");
        aa.add("F3");
        for (String temp :
                aa) {
            if ("F3".equals(temp)) {
                aa.remove(temp);
            }
        }
        for (String temp :
                aa) {
            System.out.println(temp);
        }
        String s = "123";
        System.out.println(s.substring(0,3));
        s.length();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.addAll(set);
        System.out.println(set2);
        StringBuffer sb = new StringBuffer();
        sb.append("abc");
        sb.append("abc");
        System.out.println(sb.toString());
        sb = new StringBuffer();
        System.out.println(sb.toString());
    }

}
