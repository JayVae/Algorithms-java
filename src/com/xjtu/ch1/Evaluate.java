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
 *  但是这个缺陷很明显，就是每次都要括号。
 */

public class Evaluate {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Stack<String> stackOps = new Stack<String>();
        Stack<Double> stackNum = new Stack<Double>();

        while(sc.hasNext()){
            String line = sc.nextLine();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]+"_");
                char aChar = chars[i];
                if (aChar == '('){
                }else if(aChar == '+'){
                    stackOps.push(aChar+"");
                }else if(aChar == '-'){
                    stackOps.push(aChar+"");
                }else if(aChar == '*'){
                    stackOps.push(aChar+"");
                }else if(aChar == '/'){
                    stackOps.push(aChar+"");
                }else if(aChar == ')'){
                    String op = stackOps.pop();
                    double v = stackNum.pop();
                    if (op.equals("+")) v=stackNum.pop()+v;
                    else if (op.equals("-")) v=stackNum.pop()-v;
                    else if (op.equals("*")) v=stackNum.pop()*v;
                    else if (op.equals("/")) v=stackNum.pop()/v;
                    stackNum.push(v);
                }else stackNum.push(Double.parseDouble(aChar+""));
            }
            System.out.println("ans");
            System.out.println(stackNum.pop());
        }
    }
}
