package com.company.liulishuo;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(maxSubArray(nums));
        }
    }

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int max = nums[0], ans = nums[0];
        for(int i = 1; i < len; i++){
            int tmp = max;
            max = Math.max(nums[i], tmp+nums[i]);
            ans = Math.max(max, ans);
        }
        return ans;

    }
}
