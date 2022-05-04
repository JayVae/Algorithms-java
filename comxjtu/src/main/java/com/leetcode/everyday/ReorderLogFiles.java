package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/3 9:38
 * @description //给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 * 有两种不同类型的日志：
字母日志：除标识符之外，所有字均由小写字母组成
数字日志：除标识符之外，所有字均由数字组成
请按下述规则将日志重新排序：
所有 字母日志 都排在 数字日志 之前。
字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
数字日志 应该保留原来的相对顺序。
返回日志的最终顺序。
 */
public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        if (logs==null || logs.length<2) return logs;
//        String[] letter = new String[]{};
//        String[] digit = new String[]{};
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String val1 = (String)o1;
                String val2 = (String)o2;
                String[] arr1 = val1.split(" ");
                String[] arr2 = val2.split(" ");
                int i=1,j=1;
                while (i<arr1.length && j<arr2.length){
                    int ans = arr1[i].compareTo(arr2[j]);
                    if (ans!=0) return ans;
                    i++;
                    j++;
                }
                if (i==arr1.length && j==arr2.length){
                    return arr1[0].compareTo(arr2[0]);
                } else if (i == arr1.length){
                    return -1;
                }else {
                    return 1;
                }

            }
        };

        for (int i = 0; i < logs.length; i++) {
            String val = logs[i];
            int index = val.indexOf(' ');
            if (val.charAt(index+1)-'9'<=0) digits.add(val);
            else {
                letters.add(val);
            }
        }
//        letters.sort(comparator);
        letters.sort((a,b)->{
            int index1 = a.indexOf(" ");
            int index2 = b.indexOf(" ");
            String a1=a.substring(index1+1);
            String b1=b.substring(index2+1);
            return a1.equals(b1) ? a.compareTo(b) : a1.compareTo(b1);
        });
        letters.addAll(digits);
        return letters.toArray(logs);
    }

    public static void main(String[] args) {
        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        String[] input = new String[]{"let1 art zero can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
        System.out.println(Arrays.toString(reorderLogFiles.reorderLogFiles(input)));
    }

}
