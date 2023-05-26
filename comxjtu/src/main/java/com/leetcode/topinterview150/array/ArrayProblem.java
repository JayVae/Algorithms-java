package com.leetcode.topinterview150.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/26 10:12
 * @description //数组/字符串问题
 * 来源：https://leetcode.cn/studyplan/top-interview-150/
 */
public class ArrayProblem {
    /**
     * 1.合并两个有序数组
     * 题目：https://leetcode-cn.com/problems/merge-sorted-array/
     * 解题思路：双指针
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     * @param nums1 有序数组1
     * @param m 有序数组1的长度
     * @param nums2 有序数组2
     * @param n 有序数组2的长度
     * @return 合并后的有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        System.arraycopy(sorted, 0, nums1, 0, m + n);
//        不能使用Arrays.copyOf()方法，因为将 nums1 引用指向了新的数组。但是，这么做的问题在于返回值没有办法传递到函数调用者。因为Java是采用按值传递的方式传递参数，nums1 只是指向一个数组的引用，函数的调用者在函数外部无法看到该引用被赋值后所指向的新的数组，也就是说函数的调用者并不能得到正确的合并后数组。因此，需要在不新建数组的情况下直接在 nums1 中进行操作，才能满足题目的要求。
//        nums1 = Arrays.copyOf(sorted, m + n);
    }

    /**
     * 2.移除元素
     * 题目：https://leetcode-cn.com/problems/remove-element/
     * 解题思路：双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 数
     */
    public int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == val) {
                while (p1 <= p2 && nums[p2] == val) {
                    p2--;
                }
                if (p1 <= p2) {
                    nums[p1] = nums[p2];
                }
                p2--;
            } else {
                p1++;
            }
        }
        return p1;
    }

    /**
     * 3. 删除有序数组中的重复项
     * 题目：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * 解题思路：双指针,一快一慢
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 数
     */
    public int removeDuplicates(int[] nums) {

        int p = 0;
        for (int i = 1; i < nums.length;i++) {
            if (nums[i-1]==nums[i]){
                continue;
            }else {
                p++;
                nums[p]=nums[i];
            }
        }
        return p+1;
    }

    /**
     * 4. 删除有序数组中的重复项 II
     * 题目：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     * 解题思路：双指针，可以有2个重复
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 数
     */
    public int removeDuplicatesII(int[] nums) {
        int p = 0;
        for (int i = 1; i < nums.length;) {
            if (nums[i-1]==nums[i]){
                int count=0;
                while (i<nums.length && nums[i-1]==nums[i]){
                    count++;
                    if (count==1){
                        p++;
                        nums[p]=nums[i];
                    }
                    i++;
                }
            }else {
                p++;
                nums[p]=nums[i];
                i++;
            }
        }
        return p+1;
    }

    /**
     * 5. 169. 多数元素
     * 题目：https://leetcode-cn.com/problems/majority-element/
     * 解题思路：排序，中间的数一定是多数元素；或者采用摩尔投票法，遇到相同的数+1，不同的数-1，最后剩下的一定是多数元素。
     * 注意摩尔投票不仅可以用于求众数，还可以求n/3、n/4等。
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param nums 数
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 6. 189. 论转数组
     * 题目：https://leetcode-cn.com/problems/rotate-array/
     * 解题思路：新建数组，然后复制.或者采用三次反转的思想，即先反转整个数组，然后反转前k个元素，最后反转后面n-k个元素。
     * @param nums 数
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 7. 121. 买卖股票的最佳时机
     * 题目：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * 解题思路：动态规划，dp[i]表示第i天卖出的最大利润，dp[i]=max(dp[i-1],prices[i]-minPrice)
     * 这类问题的关键通用解法是动态规划。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param prices 价格
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
//贪心
    public int maxProfitII(int[] prices) {
        int ans = 0;
        if (prices.length==1) return ans;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]){
                ans += prices[i]-prices[i-1];
            }
        }
        return ans;
    }
//    55.跳跃游戏:典型的贪心算法
//    下面的实现是BFS，时间太长了。。
//    还可以使用动态规划来做。dp[i]：从[0,i]的任意一点处出发，你最大可以跳跃到的位置。递推公式dp[i]=max(dp[i−1],nums[i]+i)。
//    https://leetcode.cn/problems/jump-game/solution/dong-tai-gui-hua-jie-fa-dpi-maxdpi-1-num-94bw/
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        dp[0]=1;
        for (int i = 0; i < n; i++) {
            if (dp[i]==1){
                for (int j = nums[i]; j >=0; j--) {
                    if (i+j<n){
                        dp[i+j]=1;
                        if (i+j==n-1) return true;
                    }
                }
            }
        }
        return dp[n-1]==1;
    }

    /**
     *
     * @Param nums
     * @Description //45. 跳跃游戏 II
     * @Date 19:15 2023/5/26
     * @return
     **/
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 0; i < n; i++) {
            if (dp[i]!=Integer.MAX_VALUE){

                for (int j = nums[i]; j >=0; j--) {

                    if (i+j<n){
                        dp[i+j]=Math.min(dp[i]+1,dp[i+j]);
                    }
                }
            }
        }
        return dp[n-1];
    }

    /**
     * 
     * @Param 
     * @Description //135. 分发糖果
     * 贪心
     * @Date 20:20 2023/5/26
     * @return 
     **/
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        int count = left[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

 /*274. H 指数
 计数排序或者直接排序
 * */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        ArrayProblem solver = new ArrayProblem();

    }
}
