package com.xjtu.ch1;

/**
 * @Author: Jay
 * @Date: Created in 10:20 2018/5/16
 * @Modified By:
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * Dijkstra的双栈算术表达式求值算法:
 *  一个存放数字；
 *  一个存放运算符。
 */
public class Evaluate {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Stack<String> stack1 = new Stack<String>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while(sc.hasNext()){
            String line = sc.nextLine();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]+"_");
                char aChar = chars[i];
                if (aChar == '('){
                }else if(aChar == '+'){

                }
            }
        }
    }
}
