package com.leetcode.Question;

public class Compare {

    public int compare(int a, int b){
        int c = a-b;
        int scA = sign(c);
        int scB = flip(scA);
        return a*scA + b*scB;
    }

    private int flip(int n) {
        return n^1;
    }

    private int sign(int n) {
        return flip((n>>31)&1);
    }

    public static void main(String[] args) {
        Compare compare = new Compare();
        System.out.println(compare.compare(3,8));
    }
}
