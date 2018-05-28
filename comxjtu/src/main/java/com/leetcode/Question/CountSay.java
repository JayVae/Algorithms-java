package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 21:32 2018/5/27
 * @Modified By:
 */

/**
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

 给定一个正整数 n ，输出报数序列的第 n 项。
 注意：整数顺序将表示为一个字符串。
 */
public class CountSay {

    public String countAndSay(int n) {
        if (n<=0){
            return "0";
        }else{
            return countSay(n);
        }
    }

    public String countSay(int n){
        if (n==1) return "1";
        else if (n==2) return "11";
        else {
            char[] last = countSay(n-1).toCharArray();
            StringBuffer sb = new StringBuffer();
            int repeatcnt = 1;
            for (int i = 0; i < last.length-1; i++) {
                if (last[i]==last[i+1]){
                    repeatcnt++;
                }else {
                    sb.append(repeatcnt);
                    sb.append(last[i]);
                    repeatcnt = 1;
                }
            }
            if (last.length>=2){
                sb.append(repeatcnt);
                sb.append(last[last.length-1]);
            }
            return sb.toString();
        }

    }
}
