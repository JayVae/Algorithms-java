package com.leetcode.everyday;


/**
 * @author JS
 * @version 1.0
 * @date 2023/3/31 14:35
 * @description //2367,算术三元组的数目，简单题
 */
public class ArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        int length = nums.length;
        int count = 0;
        int mark[] = new int[length];
        for (int i = 0; i < length; i++) {
            if (mark[i]!=1){
                int base = nums[i]+diff;
                int position = binarySearch(nums,i,length-1,base);
                if (position!=-1){
                    mark[position]=1;
                    while (base<nums[length-1] ) {
                        base = base+diff;
                        position = binarySearch(nums,position,length-1,base);
                        if (position!=-1){
                            count++;
                            mark[position]=1;
                        }else break;
                    }
                }
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int low, int hi, int res){

        while (low <= hi){
            int mid = (hi - low)/2 + low;
            if (nums[mid]<res){
                low = mid+1;
            } else if (nums[mid]>res) {
                hi = mid-1;
            }else {
                return mid;
            }
//            mid = (hi - low)/2 + low;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,4,6,7,10};
        int diff = 3;
        ArithmeticTriplets solver = new ArithmeticTriplets();
        int ans = solver.arithmeticTriplets(nums, diff);
        System.out.println(ans);
    }
}
