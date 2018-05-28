package com.leetcode.Question;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Jay
 * @Date: Created in 10:19 2018/5/28
 * @Modified By:
 */
public class ValidParentheses2 {
    public boolean isValid(String s) {
        if (s == null || s.length()%2!=0 ){
            return false;
        }else if(s.isEmpty()){
            return true;
        }else if (!(s.startsWith("(")||s.startsWith("[")||s.startsWith("{"))){
            return false;
        }else if (!(s.endsWith(")")||s.endsWith("]")||s.endsWith("}"))){
            return false;
        }
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        map.put('(',1);
        map.put(')',-1);
        map.put('[',2);
        map.put(']',-2);
        map.put('{',3);
        map.put('}',-3);
        Stack<Character> left = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch)>0){
                left.push(ch);
            }else if (map.get(ch)<0){
                char popch = left.pop();
                if ((map.get(ch)+map.get(popch))==0){
                    continue;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
