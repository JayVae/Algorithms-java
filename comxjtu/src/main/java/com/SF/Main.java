package com.SF;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            if (s.length()<=5){
                System.out.println("NULL");
                continue;
            }
            String ans = longestPalindrome(s);
            if (ans.length()<=5){
                System.out.println("NULL");
            }else {
                System.out.println(ans);
            }
        }
    }

    private static String longestPalindrome(String s) {
        int n=s.length();
        String longset = "";
        for (int i = 0; i < n - 1; i++) {
            String p1 = getPal(s,i,i);
            if (p1.length()>longset.length()){
                longset = p1;
            }
            String p2 = getPal(s,i,i+1);
            if (p2.length()>longset.length()){
                longset = p2;
            }
        }
        return longset;
    }

    private static String getPal(String s, int l, int r) {
        int n = s.length();
        while (l >= 0 && r <=n-1 && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }

}
