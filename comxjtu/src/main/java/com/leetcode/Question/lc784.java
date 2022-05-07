package com.leetcode.Question;

import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/7 11:43
 * @description //TODO
 */
public class lc784 {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new LinkedList<>();
        backtrack(result, s, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String s, String now, int i) {
        if (i==s.length()){
            result.add(now);
            return;
        }

        backtrack(result, s, now+s.charAt(i), i+1);
        if (s.charAt(i)>='a' && s.charAt(i)<='z'){
            backtrack(result, s, now+(char)(s.charAt(i)-32), i+1);
        }
        if (s.charAt(i)>='A' && s.charAt(i)<='Z'){
            backtrack(result, s, now+(char)(s.charAt(i)+32), i+1);
        }
    }
}
