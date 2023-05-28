package com.leetcode.otherSet.BinarySearch;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/28 16:42
 * @description //二分查找专题
 */
public class binarySearchAll {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = nums.length;

        while (l<=r){
            int mid = l + (r-l)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid] > target) {
                r = mid-1;
            }else l = mid+1;
        }
        return l;
    }

//74. 搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m-1;

        while (l<=r){
            int mid = l + (r-l)/2;
            if (matrix[mid][0]==target) return true;
            else if (matrix[mid][0] > target) {
                r = mid - 1;
            }else l=mid+1;
        }
        if (l==0) return false;
        int row = l-1;
        l = 0;
        r = n-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (matrix[row][mid]==target) return true;
            else if (matrix[row][mid] > target) {
                r = mid - 1;
            }else l=mid+1;
        }
        return false;
    }

/*
162. 寻找峰值：
参考：https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode-solution-96sj/
为什么能用二分查找？因为题目中说了 nums[-1] = nums[n] = -∞， nums[i] != nums[i+1]，那么 nums[i] 和 nums[i+1] 一定有一个是上升的，有一个是下降的，所以可以用二分查找
核心：首先要注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
关键：right 为什么是 nums.length - 2 ？这道题比较特殊，是为了防止nums[mid + 1]越界
* */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
/*33. 搜索旋转排序数组
* 核心：将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
* */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l+(r-l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

//    34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                if (ans[0]==-1){
                    ans[0] = mid;
//                    ans[1] = mid;
                }else {
                    ans[0] = Math.min(ans[0], mid);
                }
                right = mid-1;
            }else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        if (ans[0]==-1) return ans;
        left = ans[0];
        right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                if (ans[1]==-1){
                    ans[1] = mid;
                }else {
                    ans[1] = Math.max(ans[1], mid);
                }
                left = mid+1;
            }else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
/*
* 153. 寻找旋转排序数组中的最小值
* 这道题的易错点在于不能用nums[mid]和nums[0]比较，比如[2,1]这个例子，会出错；以及[3,1,2]这个例子，也会出错，因为这两个例子中，nums[mid]<nums[0]，但是最小值在右边。
* 而应该用nums[mid]和nums[n-1]比较，可以保证最小值在nums[n-1]的左边或者就是nums[n-1]。
* */
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r=n-1;

        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]>nums[n-1]){
//                左半部分单调
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return nums[l];
    }
/*
4. 寻找两个正序数组的中位数
* 可以看到，比较 A[k/2−1] 和 B[k/2−1] 之后，可以排除 k/2 个不可能是第 k 小的数，查找范围缩小了一半。同时，我们将在排除后的新数组上继续进行二分查找，并且根据我们排除数的个数，减少 k 的值，这是因为我们排除的数都不大于第 k 小的数。
* */
public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    return 0.0;
}
    public static void main(String[] args) {
        binarySearchAll solver = new binarySearchAll();
//        matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 80;
        System.out.println(solver.searchMatrix(matrix, target));
//        matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13


    }
}
