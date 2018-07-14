package com.leetcode.Question;

import java.util.*;

/**
 * @Author: Jay
 * @Date: Created in 20:08 2018/7/13
 * @Modified By:
 */
public class lc205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length())
            return false;
        if (s.length()==0) return true;
        Map<Character,Character> map = new HashMap<>();
        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (!map.get(ch).equals(t.charAt(i)))
                    return false;
            }else {
                if (unique.contains(t.charAt(i)))
                    return false;
                map.put(ch,t.charAt(i));
                unique.add(t.charAt(i));
            }
        }
        return true;
    }
}
