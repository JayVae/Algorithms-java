package com.leetcode.Question;

import com.xjtu.ch1.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 10:31 2018/7/14
 * @Modified By:
 */
public class lc71 {

    public String simplifyPath(String path) {
        String[] str = path.split("/+");
        String res = "";
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList();
        for (int i = 1; i < str.length; i++) {
            if (str[i].equals(".")){
                continue;
            } else if (str[i].equals("..")){
                if (stack.isEmpty())
                    continue;
                else
                    stack.pop();
            } else {
                stack.push(str[i]);
            }
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        for (int i = list.size()-1; i >= 0; i--) {
            res = res + "/"+list.get(i);
        }
        if (res.equals(""))
            res = "/";
        return res;
    }
    public static void main(String[] args){
        String[] str = "/a/./b/../../c/".split("/+");
        for (String s :
                str) {
            System.out.print(s+",");
        }
        System.out.println();
        System.out.println(str.length);
    }
}
