package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/13 10:21
 * @description //面试题 01.05. 一次编辑
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second==null) return false;
        if (Math.abs(first.length()-second.length())>1) return false;
        int count = 0;
        if (first.length() == second.length()){
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i)!=second.charAt(i)) count++;
                if (count==2) return false;
            }
            return true;
        }else {
            if (first.length()<second.length()){
                int j=0;
                count = 0;
                for (int i = 0; i < first.length(); i++) {
                    if (first.charAt(i)!=second.charAt(j)){
                        if (count==0){
                            if (first.charAt(i)!=second.charAt((j+1))){
                                return false;
                            }else {
                                count++;
                                i = i-1;
                            }
                        }else return false;
                        j++;
                    }else {
                        j++;
                    }
                }
            }else {
                int j=0;
                count = 0;
                for (int i = 0; i < second.length(); i++) {
                    if (second.charAt(i)!=first.charAt(j)){
                        if (count==0){
                            if (second.charAt(i)!=first.charAt((j+1))){
                                return false;
                            }else {
                                count++;
                                i = i-1;
                            }
                        }else return false;
                        j++;
                    }else {
                        j++;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("dinitrophenylhydrazine".length());
        System.out.println("acetylphenylhydrazine".length());
    }
}
