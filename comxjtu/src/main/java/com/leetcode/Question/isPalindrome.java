package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 17:11 2018/5/25
 * @Modified By:
 */
public class isPalindrome {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int N = s.length();
        if (N<=1) return true;
        for (int i = 0; i < N/2; i++) {
            if (s.charAt(i)!=s.charAt(N-1-i)) return false;
        }
        return true;
    }

}
