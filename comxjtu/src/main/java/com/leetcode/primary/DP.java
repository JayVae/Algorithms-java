package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 10:43 2018/5/31
 * @Modified By:
 */
public class DP {
    /**
     * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     注意：给定 n 是一个正整数。
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        int[] cn = new int[n+1];
        cn[1]=1;
        cn[2]=2;
        return count(n,cn);
    }
    private int count(int n,int[] cn){
//        if (n==0) return 1;
        if (cn[n-2]==0){
            cn[n-2] = count(n-2,cn);
        }
        if (cn[n-1]==0){
            cn[n-1] = count(n-1,cn);
        }
        return cn[n-1]+cn[n-2];
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     注意你不能在买入股票前卖出股票。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else{
                if(profit<prices[i]-min){
                    profit = prices[i]-min;
                }
            }
        }
        return profit;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 从上到下分别是O(N3),O(N2),分治法O(NlogN)，和递归
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i]>maxSum) maxSum=nums[i];
        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int sum = 0;
                for (int k = i; k <= j ; k++) {
                    sum+=nums[k];
                }
                if (sum>maxSum){
                    maxSum=sum;
                }
            }
        }
        return maxSum;
    }
    public int maxSubArray1(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i]>maxSum) maxSum=nums[i];
        }
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum>maxSum) maxSum=sum;
            }
        }
        return maxSum;
    }

    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i]>maxSum) maxSum=nums[i];
            if (nums[i]<0) cnt++;
            else break;
        }
        if (cnt==len) return maxSum;
        int sum = 0;
        int left=0;
        int right=nums.length-1;
        return MaxSubSum(nums,left,right);
    }
    private int MaxSubSum( int A[], int Left, int Right)
    {
        int MaxLeftSum,MaxRightSum;
        int MaxLeftBorderSum,MaxRightBorderSum;
        int LeftBorderSum,RightBorderSum;
        int Center,i;

        if(Left == Right)
        {
            if(A[Left] > 0)
                return A[Left];
            else
                return 0;
        }

        Center = (Left + Right)/2;
        MaxLeftSum = MaxSubSum(A,Left,Center);
        MaxRightSum = MaxSubSum(A,Center+1,Right);

        MaxLeftBorderSum = 0;
        LeftBorderSum = 0;
        for(i = Center;i >= Left;i--)
        {
            LeftBorderSum += A[i];
            if(LeftBorderSum > MaxLeftBorderSum)
                MaxLeftBorderSum = LeftBorderSum;
        }

        MaxRightBorderSum = 0;
        RightBorderSum = 0;
        for(i = Center+1;i <= Right;i++)
        {
            RightBorderSum += A[i];
            if(RightBorderSum > MaxRightBorderSum)
                MaxRightBorderSum = RightBorderSum;
        }

        return Max(MaxLeftSum,MaxRightSum,MaxLeftBorderSum + MaxRightBorderSum);
    }
    private int Max(int a, int b, int c)
    {
        if(a>b && a>c)
            return a;
        else if(b>a && b>c)
            return b;
        else
            return c;
    }
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i]>maxSum) maxSum=nums[i];
            if (nums[i]<0) cnt++;
            else break;
        }
        if (cnt==len) return maxSum;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum>maxSum)
                maxSum = sum;
            else if (sum<0)
                sum =0;
        }
        return maxSum;
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int len = nums.length;
        return maxRob(nums,len-1);
    }
    private int maxRob(int[] nums, int n){
        if (n==0) return nums[0];
        if (n==1) return nums[1]>nums[0]?nums[1]:nums[0];
        int r1 = maxRob(nums,n-1);
        int r2 = maxRob(nums,n-2)+nums[n];
        return r1>r2?r1:r2;
    }
    public int rob2(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int len = nums.length;
        int dp1 = nums[0];
        int dp2 = nums[1]>nums[0]?nums[1]:nums[0];
        if (len==2) return dp2;
        for (int i = 2; i < len; i++) {
            if (dp1+nums[i]>dp2){
                int tmp = dp2;
                dp2 = dp1+nums[i];
                dp1 = tmp;
            }else {

            }
        }
        return dp1>dp2?dp1:dp2;
    }

    public static void main(String[] args){
        DP dp = new DP();
        System.out.println(dp.climbStairs(80));
        int ans = dp.maxSubArray2(new int[]{-1,-6,-9,4,-8,5,-4,2,-1,1,-8,0,1,3,1});
        System.out.println(dp.maxSubArray2(new int[]{-1,-6,-9,4,-8,5,-4,2,-1,1,-8,0,1,3,1}));;
        int a = dp.rob2(new int[]{1,2,3,1});
    }
}
