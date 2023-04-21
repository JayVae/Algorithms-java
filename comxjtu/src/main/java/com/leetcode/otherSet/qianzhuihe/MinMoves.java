package com.leetcode.otherSet.qianzhuihe;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/21 15:23
 * @description //1674. 使数组互补的最少操作次数
 * 差分数组：对于某个区间上的数组值进行增减。diff[i]=a[i]-a[i-1]
 * 当对一个区间进行增减某个值的时候，他的差分数组对应的区间左端点的值会同步变化，而他的右端点的后一个值则会相反地变化，其实这个很好理解
 */
public class MinMoves {

    /**
     *
     * @Param
     * @Description //差分数组：
     * 设arr[]为将所有数对和转化成某一个数需要的操作次数，其中arr[i]表示将所有数对和转化成i需要的次数。
     * arr[i]为diff的前缀和。
     * https://blog.csdn.net/qq_36025591/article/details/110311658
     * https://leetcode.cn/problems/minimum-moves-to-make-array-complementary/solution/javaonde-chai-fen-shu-zu-by-liusandao/
     * @Date 15:39 2023/4/21
     * @return
     **/
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[limit * 2 + 1];
        for (int i = 0; i < nums.length / 2; i++) {
            int max = Math.max(nums[i], nums[nums.length - i - 1]);
            int min = Math.min(nums[i], nums[nums.length - i - 1]);
            if (min == 1) {
                diff[2] += 1;
            } else{
                diff[2] += 2;
                diff[min + 1] -= 1;
            }
            diff[max + min] -= 1;
            if (max + min + 1 < diff.length) {
                diff[max + min + 1] += 1;
            }
            if (max + limit + 1 < diff.length) {
                diff[max + limit + 1] += 1;
            }
        }
        int now = 0, res = nums.length / 2;
        for (int i = 2; i < diff.length; i++) {
            now += diff[i];
            res = Math.min(res, now);
        }
        return res;
    }
}
