package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/12 9:25
 * @description //1147. 段式回文
 */
public class LongestDecomposition {

    public int longestDecomposition(String text) {
        int ans = 0;
        int left = 0, right = text.length()-1;
        for (;left <= right;){
            for (int size = 1;; size++) {
                if (size*2>right-left+1){
                    ans++;
                    left = right+1;
                    break;
                }
                if (text.substring(left, left+size).equals(text.substring(right-size+1,right+1))){
                    ans++;
                    left += size;
                    right -= size;
                    if (left-1<right+1) ans++;
                    break;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        int left = 0, right = text.length()-1;
        int size = 1;
        System.out.println(text.substring(left, left+size));
        System.out.println(text.substring(right-size+1,right+1));
        System.out.println(text.substring(left, left+size).equals(text.substring(right-size+1,right+1)));
        size = 2;
        System.out.println(text.substring(left, left+size).equals(text.substring(right-size+1,right+1)));
        size = 3;
        System.out.println(text.substring(left, left+size).equals(text.substring(right-size+1,right+1)));
        System.out.println(text);
        LongestDecomposition solver = new LongestDecomposition();
        int ans = solver.longestDecomposition(text);
        System.out.println(ans);
        text = "merchant";
        ans = solver.longestDecomposition(text);
        System.out.println(ans);
        text = "antaprezatepzapreanta";
        ans = solver.longestDecomposition(text);
        System.out.println(ans);
        text = "aaa";
        ans = solver.longestDecomposition(text);
        System.out.println(ans);
    }
}
