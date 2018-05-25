package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 16:11 2018/5/25
 * @Modified By:
 */

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * hint:这里我使用了对Exception进行溢出捕获处理。
 */
public class InverseInt {
    public int reverse(int x) {
        int ans = x;
        String str = String.valueOf(x);
        char[] chr = str.toCharArray();
        if (chr[0]=='-'){
            for (int i = 1; i < chr.length/2+1; i++) {
                char tmp = chr[i];
                chr[i] = chr[chr.length-i];
                chr[chr.length-i] = tmp;
            }
        }else {
            for (int i = 0; i < chr.length / 2; i++) {
                char tmp = chr[i];
                chr[i] = chr[chr.length-1-i];
                chr[chr.length-1-i] = tmp;
            }
        }
        try{
            ans = Integer.valueOf(String.valueOf(chr));
        }catch (Exception e){
            System.out.println(0);
            return 0;
        }
        return ans;
    }
}
