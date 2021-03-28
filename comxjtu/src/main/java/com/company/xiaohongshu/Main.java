package com.company.xiaohongshu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String s = in.nextLine();
            String ans = getAns(s);
            System.out.println(ans);
        }
    }

    private static String getAns(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        int cnt=0;
        for (int i = 1; i < s.length(); i++) {
            if (chars[i]==chars[i-1]){
                cnt++;
            }else {
                if (cnt==0){
                    sb.append(chars[i-1]);
                }else {
                    sb.append(cnt);
                    sb.append(chars[i-1]);
                }
                cnt = 0;
            }
        }
        if (cnt==0) sb.append(chars[s.length()-1]);
        else {
            sb.append(cnt);
            sb.append(chars[s.length()-1]);
        }
        return sb.toString();
    }


}
