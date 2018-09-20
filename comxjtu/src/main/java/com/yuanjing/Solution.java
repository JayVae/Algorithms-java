package com.yuanjing;

public class Solution {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if (length==2){
            num1[0] = array[0];
            num2[0] =array[1];
        }
        int bit = 0;
        for (int i = 0; i < length; i++) {
            bit ^= array[i];
        }
        int inx = findFirst(bit);
        for (int i = 0; i < length; i++) {
            if (isBit(array[i],inx)){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst(int bit) {
        int inx = 0;
        while (((bit & 1) == 0) && inx < 32){
            bit = bit >> 1;
            inx++;
        }
        return inx;
    }

    private boolean isBit(int i,int inx){
        i = i >> inx;
        return (i & 1)==1;
    }

    public static void main(String[] args){
        int [] array=new int[]{1,2,3,4,5,0,8,11,3,5};
        int num1[] = new int[2];
        int num2[] = new int[2];
        new Solution().FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+","+num2[0]);
    }
}
