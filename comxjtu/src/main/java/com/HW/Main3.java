package com.HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            Answer answer = longestRepeatedSeq(s);
            System.out.println(answer.getAns()+" "+answer.getMax());
        }
    }
    private static Answer longestRepeatedSeq(String s){
        String ans = "";
        int max = 3;
        char[] chars = s.toCharArray();
        int len = s.length();
        int[][] d = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (chars[i] == chars[j]){
                    if (i==0 || (j-d[i-1][j-1])<=i) d[i][j]=1;
                    else d[i][j]=d[i-1][j-1]+1;
                    if (d[i][j]>max) {
                        max = d[i][j];
                        StringBuffer sb = new StringBuffer();
                        sb.append("");
                        for (int k = j-max+1; k < j+1; k++) {
                            sb.append(chars[k]);
                        }
                        ans = sb.toString();
                    }
                }else {
                    d[i][j] = 0;
                }
            }
        }
        if (max==3) max=0;
        return new Answer(max,ans);
    }
    static class Answer{
        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public String getAns() {
            return ans;
        }

        public void setAns(String ans) {
            this.ans = ans;
        }

        public Answer(int max, String ans) {
            this.max = max;
            this.ans = ans;
        }

        int max;
        String ans;
    }
}
