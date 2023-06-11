package com.leetcode.topinterview150.array;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/11 9:03
 * @description //分治法
 */
public class DivideandConquer {

    /*
    * 108. 将有序数组转换为二叉搜索树
    * 基本的深度搜索，即递归
    * */
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = divide(nums, 0, n-1);
        return root;

    }

    private TreeNode divide(int[] nums, int left, int right) {
        if (left>right) return null;

        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftNode = divide(nums, left, mid-1);
        TreeNode rightNode = divide(nums, mid+1,right);
        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

    /*
    * 148. 排序链表
    * 对链表的排序可以用归并排序：分治法。
    * 难点在于确定链表的中点（快慢指针）、对两个链表进行合并（可以有两种思路：递归或迭代）
    * */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        DivideandConquer solver = new DivideandConquer();
        TreeNode ans = solver.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println("end");
    }
}
