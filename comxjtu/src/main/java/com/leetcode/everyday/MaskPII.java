package com.leetcode.everyday;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/1 16:25
 * @description //831
 */
public class MaskPII {

    public String maskPII(String s) {
//        1.判断是邮箱还是电话；@
        StringBuilder ans = new StringBuilder("");
        if (s.contains("@")){
            //        2.邮箱：（1）转小写；（2）分割，@；（3）替换，拼接
            s = s.toLowerCase();
            String[] strs = s.split("@");
            int len = strs[0].length();
            ans.append(strs[0].charAt(0)).append("*****").append(strs[0].charAt(len-1)).append("@").append(strs[1]);
        }else {
            //        3.电话：（1）只留下数字；（2）判断长度；（4）按照对应模式拼接+最后四位
            char[] chars = s.toCharArray();
            HashSet<Character>  characterHashSet = new HashSet<>();
            characterHashSet.add(' ');
            characterHashSet.add('(');
            characterHashSet.add(')');
            characterHashSet.add('-');
            characterHashSet.add('+');
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                if (!characterHashSet.contains(aChar) ){
                    count++;
                    sb.append(aChar);
                }
            }
            switch (count){
                case 10:
                    ans.append("***-***-");
                    break;
                case 11:
                    ans.append("+*-***-***-");
                    break;
                case 12:
                    ans.append("+**-***-***-");
                    break;
                default:
                    ans.append("+***-***-***-");
            }
            ans.append(sb.toString().substring(count-4));

        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder("");
        String s = "LeetCode@LeetCode.com";
        s = s.toLowerCase();
        String[] strs = s.split("@");
        int len = strs[0].length();
        ans.append(strs[0].charAt(0)).append("*****").append(strs[0].charAt(len-1)).append("@").append(strs[1]);
        System.out.println(ans);

        MaskPII solver = new MaskPII();
        Scanner sc = new Scanner(System.in);
        while (true){
            String line = sc.nextLine();
            System.out.println(solver.maskPII(line));
        }

//        String ss = s.substring(s.length()-4);
//        System.out.println(ss);
    }
}
