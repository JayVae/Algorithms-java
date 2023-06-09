package com.leetcode.otherSet.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/28 16:42
 * @description //二分查找专题
 */
public class binarySearchAll {

//    标准模板
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;

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
* 这道题可以转化成寻找两个有序数组中的第 k 小的数，其中 k 为 (m+n)/2 或 (m+n)/2+1。
* 可以看到，比较 A[k/2−1] 和 B[k/2−1] 之后，可以排除 k/2 个不可能是第 k 小的数，查找范围缩小了一半。同时，我们将在排除后的新数组上继续进行二分查找，并且根据我们排除数的个数，减少 k 的值，这是因为我们排除的数都不大于第 k 小的数。
* */
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length1 = nums1.length, length2 = nums2.length;
    int totalLength = length1 + length2;
    if (totalLength % 2 == 1) {
        int midIndex = totalLength / 2;
        double median = getKthElement(nums1, nums2, midIndex + 1);
        return median;
    } else {
        int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
        double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        return median;
    }
}

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

/*
* 378. 有序矩阵中第 K 小的元素
* */
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int left = matrix[0][0];
            int right = matrix[n - 1][n - 1];
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (check(matrix, mid, k, n)) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean check(int[][] matrix, int mid, int k, int n) {
            int i = n - 1;
            int j = 0;
            int num = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= mid) {
                    num += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            return num >= k;
        }

        /*
        * 373. 查找和最小的 K 对数字
        * */
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int m = nums1.length;
            int n = nums2.length;

            /*二分查找第 k 小的数对和的大小*/
            int left = nums1[0] + nums2[0];
            int right = nums1[m - 1] + nums2[n - 1];
            int pairSum = right;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                long cnt = 0;
                int start = 0;
                int end = n - 1;
                while (start < m && end >= 0) {
                    if (nums1[start] + nums2[end] > mid) {
                        end--;
                    } else {
                        cnt += end + 1;
                        start++;
                    }
                }
                if (cnt < k) {
                    left = mid + 1;
                } else {
                    pairSum = mid;
                    right = mid - 1;
                }
            }

            List<List<Integer>> ans = new ArrayList<>();
            int pos = n - 1;
            /*找到小于目标值 pairSum 的数对*/
            for (int i = 0; i < m; i++) {
                while (pos >= 0 && nums1[i] + nums2[pos] >= pairSum) {
                    pos--;
                }
                for (int j = 0; j <= pos && k > 0; j++, k--) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    ans.add(list);
                }
            }

            /*找到等于目标值 pairSum 的数对*/
            pos = n - 1;
            for (int i = 0; i < m && k > 0; i++) {
                int start1 = i;
                while (i < m - 1 && nums1[i] == nums1[i + 1]) {
                    i++;
                }
                while (pos >= 0 && nums1[i] + nums2[pos] > pairSum) {
                    pos--;
                }
                int start2 = pos;
                while (pos > 0 && nums2[pos] == nums2[pos - 1]) {
                    pos--;
                }
                if (nums1[i] + nums2[pos] != pairSum) {
                    continue;
                }
                int count = (int) Math.min(k, (long) (i - start1 + 1) * (start2 - pos + 1));
                for (int j = 0; j < count && k > 0; j++, k--) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[pos]);
                    ans.add(list);
                }
            }
            return ans;
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
