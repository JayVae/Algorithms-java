package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 20:48 2018/9/3
 * @Modified By:
 */
public class ZTE {

    public  List<String> getCommon(char[] chars,int cnt){
        List<String> list = new LinkedList<>();
        Arrays.sort(chars); // not necessary
        backtrack(list,"", chars,0,cnt);
        return list;
    }

    private void backtrack(List<String> list,String str, char[] chars, int index,int cnt) {
        if (cnt==0){
            if (!list.contains(str)){
                list.add(str);
            }
        }
        for (int j = index; j < chars.length; j++) {
            backtrack(list,str+chars[j],chars,j+1,cnt-1);
            backtrack(list,str,chars,j+1,cnt);
        }
    }

    public static void main(String[] args){
        char[] chars = new char[]{'a','d','h','c','z'};
        List<String> list = new ZTE().getCommon(chars,3);
        System.out.print("[");
        for (String str :
                list) {
            System.out.println(str+",");
        }
        System.out.println("]");
    }
}
