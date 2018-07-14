package com.leetcode.Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Jay
 * @Date: Created in 19:42 2018/7/13
 * @Modified By:
 */
public class lc290 {

    public boolean wordPattern(String pattern, String str) {
        String[] strarr = str.split(" ");
        if (strarr.length!=pattern.length())
            return false;
        if (pattern.length()==0) return true;
        Map<Character,String> map = new HashMap<>();
        Set<String> unique = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))){
                String tmp = map.get(pattern.charAt(i));
                if (!tmp.equals(strarr[i]))
                    return false;
            }else {
                if (unique.contains(strarr[i])) return false;
                map.put(pattern.charAt(i),strarr[i]);
                unique.add(strarr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("dog cat".split(" ").length);
    }
}
