package com.leetcode.everyday;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/2 11:02
 * @description //lc591给定一个表示代码片段的字符串，你需要实现一个验证器来解析这段代码，并返回它是否合法。
 * 题目比较长，具体可以查看
 */
public class TagValidator {

    /**
     *
     * @Description //思路及关键点：
     * 1. 解析：
     *       （1）判断属于哪种模式：
     *                 闭合标签模式 <  和内容模式（又具体包括代码注释cdata，任意字符）
     *                 <  <![  </ 以及任意字符：通过正则来判断
     *       （2）全局判断：< 没有对应的>
     * 2. 闭合标签模式：<TAG_NAME>TAG_CONTENT</TAG_NAME>
     *       （1）标签名：正则
     *       （2）判断匹配：标签栈，解析到结束标签时，比较名字是否相同
     *       （3）嵌套标签：标签栈
     *       //(4) 没有对应的>
     * 3. 代码注释cdata模式：<![CDATA[CDATA_CONTENT]]>
     *        （1）CDATA_CONTENT为任意字符，其中可以包括闭合标签，也就是其中的内容不解析，屏蔽,用flag。
     *          （2）需要判断CDATA_CONTENT结束时，第一个]]>
     *
     * @Date 11:03 2022/5/2
     * @return
     **/
    public boolean isValid2(String code) {
        if (code==null || code.length()==0 || !code.startsWith("<")) return false;
        int index = 0;
        boolean tagFlag, codeFlag;
        while(true){
            if (code.charAt(index)=='<'){
                tagFlag = code.matches("^<[A-Z]{1,9}>.*");
                codeFlag = code.matches("^<!\\[.*");
                if (tagFlag){

                }
            }
            if (index == 1) break;
        }

        return true;

    }

    public boolean isValid(String code) {
        int n = code.length();
        Stack<String> tags = new Stack<>();

        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                if (code.charAt(i + 1) == '/') {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 2, j);
                    if (tags.isEmpty() || !tags.peek().equals(tagname)) {
                        return false;
                    }
                    tags.pop();
                    i = j + 1;
                    if (tags.isEmpty() && i != n) {
                        return false;
                    }
                } else if (code.charAt(i + 1) == '!') {
                    if (tags.isEmpty()) {
                        return false;
                    }
                    if (i + 9 > n) {
                        return false;
                    }
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 1;
                } else {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 1, j);
                    if (tagname.length() < 1 || tagname.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < tagname.length(); ++k) {
                        if (!Character.isUpperCase(tagname.charAt(k))) {
                            return false;
                        }
                    }
                    tags.push(tagname);
                    i = j + 1;
                }
            } else {
                if (tags.isEmpty()) {
                    return false;
                }
                ++i;
            }
        }

        return tags.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String code = scanner.nextLine();
            System.out.println(code+":     "+code.matches("^<[A-Z]{1,9}>.*"));
            System.out.println(code+":     "+code.matches("^<!\\[.*"));
        }
    }
}
