package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 16:44 2018/5/27
 * @Modified By:
 */

import com.xjtu.ch1.Stack;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {
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
//        Set strset = new HashSet<Character>();
        Set leftset = new HashSet<Character>();
        leftset.add('(');
        leftset.add('[');
        leftset.add('{');
        Set rightset = new HashSet<Character>();
        rightset.add(')');
        rightset.add(']');
        rightset.add('}');
        Stack<Character> left = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (leftset.contains(ch)){
                left.push(ch);
            }else if (rightset.contains(ch)){
                char popch = left.pop();
                if ((ch-popch)== 1 || (ch-popch)== 2){
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
