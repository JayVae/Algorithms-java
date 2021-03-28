package com.company.HW;


import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            System.out.println(longestValid(s));
        }
    }
    private static int longestValid(String s){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(') stack.push(i);
            else if(s.charAt(i)!=')'){
                stack = new Stack();
            }else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max,i-left);
                    else max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}
