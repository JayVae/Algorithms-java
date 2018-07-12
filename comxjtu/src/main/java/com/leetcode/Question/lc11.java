package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 15:59 2018/7/12
 * @Modified By:
 */
public class lc11 {
    /**
     * 盛最多水的容器：
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 对撞指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int hi = height.length-1,lo=0;
        int max = 0;
        while (hi>lo){
            int area = 0;
            if (height[lo]<height[hi])
                area = (hi-lo)*height[lo];
            else
                area = (hi-lo)*height[hi--];
            if (max<area)
                max = area;
        }
        return max;
    }
}
