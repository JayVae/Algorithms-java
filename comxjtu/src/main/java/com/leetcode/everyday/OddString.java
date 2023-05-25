package com.leetcode.everyday;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/25 20:32
 * @description //TODO
 */
public class OddString {

    public String oddString(String[] words) {
        HashMap<String, Integer> hash = new LinkedHashMap<>();
        int count = 0;
        for (String word : words) {
            count++;
            StringBuilder diff = new StringBuilder();
            for (int i = 0; i < word.length()-1; i++) {
                diff.append("*");
                diff.append(word.charAt(i+1)-word.charAt(i));
            }
            String s= diff.toString();
            if (!hash.containsKey(s)){
                if (count>3){
                    return word;
                }else {
                    hash.put(s,1);
                }
            }else {
                hash.put(s,hash.get(s)+1);
            }
        }


        for(String key:hash.keySet()) {
            int value = hash.get(key);
            if (value==1){
                for (int j = 0; j < 3; j++) {
                    StringBuilder diff = new StringBuilder();
                    for (int i = 0; i < words[j].length()-1; i++) {
                        diff.append("*");
                        diff.append(words[j].charAt(i+1)-words[j].charAt(i));
                    }
                    String s= diff.toString();
                    if (s.equals(key)){
                        return words[j];
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        OddString solver = new OddString();
        String[] words = {"abm","bcn","alm"};
        System.out.println(solver.oddString(words));
    }
}
